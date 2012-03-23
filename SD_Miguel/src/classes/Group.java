/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class Group {
    private int id;
    private int maxSize;
    private int roomId = -1;
    private ArrayList<OrdinaryThief> thieves;

    public Group(int id, int maxSize) {
        assert id >= 0 : "Invalid group id";
        assert maxSize > 0 : "Invalid group size";
        
        this.id = id;
        this.maxSize = maxSize;
        this.thieves = new ArrayList(maxSize);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the maxSize
     */
    public int getMaxSize() {
        return maxSize;
    }

    public boolean isIdle() {
        return roomId == -1;
    }
    public void setIdle() {
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
        assert roomId >= 0 : "Invalid room";
        
        this.roomId = roomId;
    }
    
    public boolean isFull() {
        return getThieves().size() == maxSize;
    }
    public boolean isEmpty() {
        return getThieves().isEmpty();
    }
    
    public void add(OrdinaryThief t) {
        assert t != null : "Invalid thief";
        assert !isFull() : "Group is full";
        assert getThieves().add(t);
    }
    public void remove(OrdinaryThief t) {
        assert t != null : "Invalid thief";
        assert !isEmpty() : "Group is empty";
        assert getThieves().remove(t);
    }

    /**
     * @return the thieves
     */
    public ArrayList<OrdinaryThief> getThieves() {
        return thieves;
    }
    
}
