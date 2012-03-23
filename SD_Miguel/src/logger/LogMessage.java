/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logger;

import classes.Group;
import classes.MasterThief;
import classes.OrdinaryThief;
import classes.Room;

/**
 *
 * @author Miguel
 */
public class LogMessage {
    
    private int tick;
    private MasterThief.Status masterStat;
    private OrdinaryThief.Status [] thievesStat;
    private int [] positions;
    private boolean [] hasCanv;
    private int [] groups;
    private int [] rooms;
    private int [] nCanv;
    
    public LogMessage (int tick, MasterThief.Status mts, OrdinaryThief.Status [] ots, int [] groups, int [] pos, boolean [] hasCanv, int [] rooms, int [] nCanv) {
        this.tick = tick;
        this.masterStat = mts;
        this.thievesStat = ots;
        this.positions = pos;
        this.hasCanv = hasCanv;
        this.groups = groups;
        this.rooms = rooms;
        this.nCanv = nCanv;
    }

    /**
     * @return the tick
     */
    public String getTick() {
        return String.valueOf(tick);
    }

    /**
     * @return the masterStat
     */
    public String getMasterStat() {
        return masterStat.toString();
    }

    /**
     * @return the thiefStat
     */
    public String getThiefStat(int thiefId) {
        return thievesStat[thiefId].toString();
    }
    
    /**
     * @return the group
     */
    public String getGroupId(int thiefId) {
        return String.valueOf(groups[thiefId]);
    }
    
    public String getPosition(int thiefId) {
        return String.valueOf(positions[thiefId]);
    }

    /**
     * @return the hasCanvas
     */
    public String hasCanvas(int thiefId) {
        return String.valueOf(hasCanv[thiefId]);
    }
    
    public String getRoomId(int groupId) {
        return String.valueOf(rooms[groupId]);
    }

    /**
     * @return the roomStat
     */
    public String getnCanvas(int roomId) {
        return String.valueOf(nCanv[roomId]);
    }
    
}
