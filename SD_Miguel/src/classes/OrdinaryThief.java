/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.memories.MemStack;

/**
 *
 * @author Miguel
 */
public class OrdinaryThief {
    
    public static final int CRAWLIN = 0;
    public static final int CRAWLOUT = 1;

    public enum Status {
        OUTSIDE,
        CRAWLING_OUTWARDS,
        AT_A_ROOM,
        CRAWLING_INWARDS;
        
        @Override
        public String toString() {
            switch (this) {
                case OUTSIDE:
                    return "OUTS";
                case CRAWLING_OUTWARDS:
                    return "CRLI";
                case AT_A_ROOM:
                    return "ROOM";
                case CRAWLING_INWARDS:
                    return "CRLO";
                default:
                    return "----";
            }
        }
    }
    
    public enum Duty { WAIT, JOIN, END }

    protected int id;
    protected int speed;
    protected Status status;
    protected Duty duty;
    protected int groupId = -1;
    protected int roomId = -1;
    protected int position = -1;
    protected int direction = CRAWLIN;
    protected MemStack<Canvas> canvasStack;
    
    public OrdinaryThief(int id) {
        this(id, 1);
    }

    public OrdinaryThief(int id, int speed) {
        assert id >= 0 : "Invalid thief id";
        assert speed > 0 : "Invalid thief speed";
        
        this.id = id;
        this.speed = speed;
    }
    
    /**
     * @return the id
     */
    public final int getId() {
        return id;
    }

    /**
     * @return the speed
     */
    public final int getSpeed() {
        return speed;
    }
    
    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }
    
    public boolean hasGroup () {
        return groupId != -1;
    }
    
    /**
     * @return the groupId
     */
    public final int getGroupId() {
        assert hasGroup() : "Thief has no group";
        
        return groupId;
    }
    
    /**
     * @param groupId the groupId to set
     */
    public final void joinGroup (int groupId) {
        assert !hasGroup() : "Thief is already on a group";
        
        this.groupId = groupId;
    }
    
    public final void leaveGroup () {
        assert hasGroup() : "Thief has no group";
        
        this.groupId = -1;
        this.roomId = -1;
    }
    
    /**
     * @return the roomId
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * @param roomId the roomId to set
     */
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    
    /**
     * @return the duty
     */
    public final Duty getDuty() {
        return duty;
    }

    /**
     * @param duty the duty to set
     */
    public final void setDuty(Duty duty) {
        this.duty = duty;
    }

    /**
     * @return the position
     */
    public final int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public final void setPosition(int position) {
        this.position = position;
    }
    
    

    /**
     * @return the direction
     */
    public final int getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public final void setDirection(int direction) {
        assert direction == CRAWLIN || direction == CRAWLOUT : "Invalid direction";
        
        this.direction = direction;
    }
    
    public boolean isIdle () { return duty == Duty.WAIT; }
    public boolean isDone () { return duty == Duty.END; }
    
    /**
     * @return the canvasStack
     */
    public MemStack<Canvas> getCanvasStack() {
        return canvasStack;
    }
}
