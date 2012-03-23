/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monitors;

import classes.Canvas;
import classes.Group;
import classes.MasterThief;
import classes.OrdinaryThief;
import classes.OrdinaryThief.Duty;
import classes.memories.MemException;
import classes.memories.MemFIFO;
import classes.memories.MemStack;
import exceptions.OutsideException;
import interfaces.IMasterOutside;
import interfaces.IOutsideReport;
import interfaces.IThiefOutside;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainProgram.Params;

/**
 *
 * @author Miguel
 */
public class Outside implements IMasterOutside, IThiefOutside {
    private enum Action { ASSEMBLE, WAIT, REPORT }
    private enum RoomStatus {
        UNKNOWN,
        UNDER_ASSAULT,
        NOT_EMPTY,
        EMPTY;
    }
    
    private Group [] groups;
    private OrdinaryThief [] thieves;
    
    private boolean [] start;
    private RoomStatus [] roomStat;
    private MemFIFO<Integer> waitingMembers = null;
    private MemStack<Canvas> canvasStack = null;
    
    private IOutsideReport report;
    
    public Outside (IOutsideReport report) {
        groups = new Group [Params.nGroups()];
        thieves = new OrdinaryThief [Params.nThieves()];
        
        for (int i = 0; i < groups.length; i++)
            groups[i] = new Group(i, Params.groupSize());
        
        for (int i = 0; i < thieves.length; i++)
            thieves[i] = new OrdinaryThief(i);
        
        this.roomStat = new RoomStatus[Params.nRooms()];
        this.waitingMembers = new MemFIFO(Params.nThieves());
        this.start = new boolean[Params.nGroups()];
        for (int i = 0; i < start.length; i++)
            start[i] = false;
        
        this.report = report;
    }
    
    @Override
    public void startOperations() {
        
        /* Initialize the room status array from the master perspective */
        
        for (int roomId = 0; roomId < roomStat.length; roomId++)
            roomStat[roomId] = RoomStatus.UNKNOWN;
        
        /* Initialize master thief's canvas stack */
        
        this.canvasStack = new MemStack(Params.totalCanvases());
        //report.setStolenCanvas(0, 0.0);
        
        /* Set master status to planning the heist */
        
        report.setMasterStatus(MasterThief.Status.PLANNING_THE_HEIST);
    }
    
    @Override
    public char appraiseSit() {
        
        /* Check rooms status */
        
        int nEmpty = 0, nAssigned = 0;
        for (int i = 0; i < roomStat.length; i++)
            switch (roomStat[i])
            {
                case EMPTY:
                    nEmpty++;
                    break;
                case UNDER_ASSAULT:
                    nAssigned++;
                    break;
            }
        
        if (nEmpty == roomStat.length)
            return 'E';     // all rooms are empty
        if (nAssigned == groups.length || nAssigned + nEmpty == roomStat.length)
            return 'W';     // no group or room available to assault 
        return 'P';         // group and room available
    }
    
    @Override
    public synchronized int prepareAssaultParty () throws OutsideException {
        
        /* Pick a room to assault */
        int roomId;
        boolean foundRoom = false;
        for (roomId = 0; roomId < roomStat.length; roomId++)
            if (roomStat[roomId] == RoomStatus.UNKNOWN || roomStat[roomId] == RoomStatus.NOT_EMPTY) {
                roomStat[roomId] = RoomStatus.UNDER_ASSAULT;
                foundRoom = true;
                break;
            }
        
        if (!foundRoom) throw new OutsideException("MasterThief didn't find any room to ackack");
        
        
        /* Pick an available group */
        
        int groupId;
        boolean foundGroup = false;
        for (groupId = 0; groupId < groups.length; groupId++)
            if (groups[groupId].isIdle()) {
                groups[groupId].setRoomId(roomId);
                foundGroup = true;
                break;
            }
        
        if (!foundGroup) throw new OutsideException("MasterThief didn't find an available group");
        
        /* Inform available thieves of their new group and awake them */
        
        int nThievesIn = 0;
        for (int thiefId = 0; thiefId < thieves.length && nThievesIn < groups[groupId].getMaxSize(); thiefId++)
            if (!thieves[thiefId].hasGroup()) {
                thieves[thiefId].joinGroup(groupId);
                thieves[thiefId].setRoomId(roomId);
                thieves[thiefId].setDuty(Duty.JOIN);
                nThievesIn++;
            }
        
        if (nThievesIn < groups[groupId].getMaxSize()) throw new OutsideException("MasterThief didn't find available thieves");
        
        /* Set master status to assembling a group */
        
        report.setMasterStatus(MasterThief.Status.ASSEMBLING_A_GROUP);
        
        /* Wait till all thieves from group prepare excursion */
        
        while (!groups[groupId].isFull())
            try {
                notifyAll();
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Outside.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return groupId;
    }
    
    @Override
    public synchronized void sendAssaultParty (int groupId) {
        start[groupId] = true;
        notifyAll();
        report.setMasterStatus(MasterThief.Status.DECIDING_WHAT_TO_DO);
    }
    
    @Override
    public synchronized int takeARest () throws OutsideException {
        
        /* Set master status to waiting for group arrival */
        
        report.setMasterStatus(MasterThief.Status.WAITING_FOR_GROUP_ARRIVAL);
        
        /* Wait for one thief to arrive */
        
        while (waitingMembers.isEmpty())
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Outside.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        /* Return next arrived thief id */
        
        int thiefId;
        try {
            thiefId = waitingMembers.read().intValue();
        } catch (MemException ex) {
            throw new OutsideException("MasterThief hasn't found any thieves outside", ex);
        }
        
        return thiefId;
    }
    
    @Override
    public synchronized void collectCanvas (int thiefId) throws OutsideException {
        
        boolean emptyRoom = false;
        
        /* Check arrived thief for canvas */
        
        if (!thieves[thiefId].getCanvasStack().isEmpty()) {
            // collect canvas
            try {
                canvasStack.write(thieves[thiefId].getCanvasStack().read());
            } catch (MemException ex) {
                throw new OutsideException("MasterThief canvas stack is full", ex);
            }
        }
        else
            emptyRoom = true;
        
        /* Take thief out of the group */
        
        int groupId = thieves[thiefId].getGroupId();
        thieves[thiefId].leaveGroup();
        groups[groupId].remove(thieves[thiefId]);
        
        /* Check if group is empty */
        
        if (groups[groupId].isEmpty()) {
            groups[groupId].setIdle(); // free group
            if (emptyRoom)
                roomStat[groups[groupId].getRoomId()] = RoomStatus.EMPTY;
        }
        
        /* Set master status to deciding what to do */
        
        report.setMasterStatus(MasterThief.Status.DECIDING_WHAT_TO_DO);
    }
    
    @Override
    public synchronized void sumUpResults() {
        
        /* Order thieves to listen the report */
        
        for (int i = 0; i < thieves.length; i++)
            thieves[i].setDuty(Duty.END);
        
        notifyAll(); // wake up thieves so they can end their lifecycle
        
        /* Set master status to presenting the report */
        
        report.setMasterStatus(MasterThief.Status.PRESENTING_THE_REPORT);
        
        /* Do the final report */
        
        int nCanvasStolen = 0;
        double profit = 0.0;
        while (!canvasStack.isEmpty())
        {
            try {
                Canvas c = canvasStack.read();
                nCanvasStolen++;
                profit += c.getValue();
            } catch (MemException ex) {
                Logger.getLogger(Outside.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //report.setStolenCanvas(nCanvasStolen, profit);
        //report.doFinalReport();
    }
    
    @Override
    public synchronized boolean amINeeded(int thiefId) {
                
        notifyAll(); // awake master thief

        /* Wait to be summoned by master thief */
        
        while (thieves[thiefId].getDuty() == Duty.WAIT)
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Outside.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        /* Return true if he must join a group, false otherwise */
        
        return thieves[thiefId].getDuty() == Duty.JOIN;
    }

    @Override
    public synchronized int prepareExcursion(int thiefId) {
        
        /* Join the assigned group */
        
        int groupId = thieves[thiefId].getGroupId();
        groups[groupId].add(thieves[thiefId]);
        
        /* Check if it's the last thief to join group */
        
        if (groups[groupId].isFull())
            notifyAll();    // inform master that the group is ready
        
        while (!start[groupId])
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Outside.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        report.setThiefStatus(thiefId, OrdinaryThief.Status.CRAWLING_OUTWARDS);
        return groups[groupId].getRoomId();
    }
    
    @Override
    public synchronized void handACanvas(int thiefId, Canvas canvas) throws OutsideException {
        
        if (canvas != null)
            try {
                thieves[thiefId].getCanvasStack().write(canvas);
            } catch (MemException ex) {
                throw new OutsideException("Thief " + thiefId + " can't carry more than one canvas");
            }
        
        /* Put thief on the arrived thieves waiting queue */
        
        try {
            waitingMembers.write(new Integer(thiefId));
        } catch (MemException ex) {
            throw new OutsideException("Waiting thieves overflow", ex);
        }
        
        thieves[thiefId].setDuty(Duty.WAIT); // release from duties
        
        notifyAll();    // inform master thief of his arrival
    }
    
    
}
