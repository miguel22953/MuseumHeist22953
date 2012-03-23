/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monitors;

import classes.*;
import interfaces.IOutsideReport;
import interfaces.IPathReport;
import interfaces.IRoomReport;
import interfaces.IWritable;
import logger.LogMessage;
import mainProgram.Params;
import viewer.IDrawable;
import viewer.drawings.ThiefDrawing;
import viewer.messages.ViewerMessage;

/**
 *
 * @author Miguel
 */
public class Repository implements IOutsideReport, IPathReport, IRoomReport{
    
    private MasterThief.Status masterStat;
    private OrdinaryThief.Status [] thievesStat;
    private int [] groups;
    private int [] positions;
    private boolean [] hasCanv;
    private int [] rooms;
    private int [] nCanv;
    
    private ThiefDrawing [] thiefDraws;
    
    private IWritable<LogMessage> logger;
    private IDrawable viewer;
    
    public Repository (IWritable<LogMessage> logger, IDrawable viewer) {
        this.logger = logger;
        this.viewer = viewer;
        this.thiefDraws = new ThiefDrawing[Params.nThieves()];
        
        for (int i = 0; i < thiefDraws.length; i++)
            thiefDraws[i] = new ThiefDrawing(i);
        
        this.masterStat = MasterThief.Status.PLANNING_THE_HEIST;
        this.thievesStat = new OrdinaryThief.Status [Params.nThieves()];
        this.groups = new int [Params.nThieves()];
        this.positions = new int [Params.nThieves()];
        this.hasCanv = new boolean [Params.nThieves()];
        for (int thiefId = 0; thiefId < Params.nThieves(); thiefId++) {
            thievesStat[thiefId] = OrdinaryThief.Status.OUTSIDE;
            groups[thiefId] = -1;
            positions[thiefId] = -1;
            hasCanv[thiefId] = false;
        }
        this.rooms = new int [Params.nGroups()];
        for (int groupId = 0; groupId < Params.nGroups(); groupId++)
            this.rooms[groupId] = -1;
        
        this.nCanv = new int [Params.nRooms()];
        System.arraycopy(Params.nCanvases(), 0, this.nCanv, 0, Params.nRooms());
        
    }
    
    @Override
    public void setMasterStatus (MasterThief.Status status) {
        this.masterStat = status;
        reportStatus();
    }
    
    @Override
    public void setThiefStatus(int thiefId, OrdinaryThief.Status status) {
        thievesStat[thiefId] = status;
        reportStatus();
    }
    
    public void setThiefGroup (int thiefId, int groupId) {
        groups[thiefId] = groupId;
        reportStatus();
    }
    
    @Override
    public void setThiefPosition (int thiefId, int position) {
        positions[thiefId] = position;
        reportStatus();
    }
    
    
    @Override
    public void setnCanvas(int roomId, int nCanvas) {
        nCanv[roomId] = nCanvas;
        reportStatus();
    }
    
    @Override
    public void setThiefCanvas (int thiefId, boolean canv) {
        hasCanv[thiefId] = canv;
        reportStatus();
    }
    
    private void reportStatus () {
        LogMessage logMsg;
        int time = LogicalClock.tick();
        logMsg = new LogMessage (time, masterStat, thievesStat, groups, positions, hasCanv, rooms, nCanv);
        logger.write(logMsg);
    }
    
    
}
