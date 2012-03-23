/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monitors;

import classes.OrdinaryThief;
import classes.RoomPath;
import classes.memories.MemException;
import classes.memories.MemFIFO;
import interfaces.IPathReport;
import interfaces.IThiefPath;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainProgram.Params;

/**
 *
 * @author Miguel
 */
public class SharedPath implements IThiefPath {

    private static final int ENTRANCE = -1;

    private RoomPath path;
    private MemFIFO<Integer> waitingQueue;
    
    private int turn = -1;
    
    private IPathReport report;
    
    public SharedPath (int length, IPathReport report) {
        this.path = new RoomPath(length);
        this.waitingQueue = new MemFIFO(Params.groupSize());
        this.report = report;
    }
    
    @Override
    public synchronized void waitOutside (int thiefId) {
        try {
            waitingQueue.write(new Integer(thiefId));
        } catch (MemException ex) {
            Logger.getLogger(SharedPath.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public synchronized boolean crawlOut(OrdinaryThief t) {
        if (turn == -1)
            turn = nextTurn(ENTRANCE);
        while (t.getId() != turn)
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SharedPath.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        int pos = t.getPosition();
        int newPos = Math.min(getBehindPos(pos) + Params.maxGap(), pos + t.getSpeed());
        if (newPos > path.roomPosition()) newPos = path.roomPosition();
        while (newPos > pos && !path.isFree(newPos))
            newPos--;
        
        if (newPos > pos)
        {
            // Thief can move
            if (pos >= 0)
                path.free(pos);
            path.occupy(newPos, t.getId());
            t.setPosition(newPos);
            report.setThiefPosition(t.getId(), newPos);
            if (newPos == path.roomPosition()) return true;
        }
        
        // Thief wasn't able to move
        if (pos == ENTRANCE)
            waitOutside(t.getId());
        
        turn = nextTurn(pos); // pass turn
        notifyAll();
        return false;
    }
    
    @Override
    public synchronized boolean crawlIn(OrdinaryThief t) {
        while (t.getId() != turn)
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SharedPath.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        int pos = t.getPosition();
        int newPos = Math.min(getBehindPos(pos) + Params.maxGap(), pos + t.getSpeed());
        if (newPos >= path.nPositions()) newPos = ENTRANCE;
        while (newPos > pos && !path.isFree(newPos))
            newPos--;
        
        if (newPos > pos || newPos == ENTRANCE)
        {
            // Thief can move
            path.free(pos);
            t.setPosition(newPos);
            report.setThiefPosition(t.getId(), newPos);
            if (newPos == ENTRANCE) {
                turn = nextTurn(path.nPositions());
                return true;
            }
            path.occupy(newPos, t.getId());
        }
        
        // Thief wasn't able to move
        turn = nextTurn(pos); // pass turn
        notifyAll();
        return false;
    }
    
    private int nextTurn (int pos) {
        int behindPos = getBehindPos(pos);
        if (behindPos == ENTRANCE) {
            if (waitingQueue.isEmpty())
                return path.getThiefIn(getFirstPos());
            else {
                int nextTurn = -1;
                try {
                    nextTurn = waitingQueue.read().intValue();
                } catch (MemException ex) {
                    Logger.getLogger(SharedPath.class.getName()).log(Level.SEVERE, null, ex);
                }
                return nextTurn;
            }
        }
        return path.getThiefIn(behindPos);
    }
        
    private int getBehindPos (int pos) {
        for (pos = pos - 1; pos >= 0; pos--)
            if (!path.isFree(pos))
                break;
        
        if (pos < 0) pos = ENTRANCE;
        return pos;
    }
    private int getFirstPos () {
        return getBehindPos(path.nPositions());
    }
}