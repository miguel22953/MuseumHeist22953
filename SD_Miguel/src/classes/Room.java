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
public final class Room {
    private int id;
    private int nCanvas;
    private int distance;
    
    public Room(int id, int nCanvas, int distance) {
        assert id >= 0 : "Invalid room id";
        assert nCanvas >= 0 : "Invalid number of canvases";
        assert distance > 0 : "Invalid room distance";
        
        this.id = id;
        this.nCanvas = nCanvas;
        this.distance = distance;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }
    
    /**
     * @return the nCanvas
     */
    public int getnCanvas() {
        return nCanvas;
    }
    
    public void removeCanvas() {
        assert nCanvas > 0 : "Room has no canvas";
        nCanvas--;
    }

}
