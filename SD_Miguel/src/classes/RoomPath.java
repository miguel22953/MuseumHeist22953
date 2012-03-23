/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Miguel
 */
public class RoomPath {
    private int roomPosition;
    private int [] positions;
    
    public RoomPath (int length) {
        this.roomPosition = length - 1;
        this.positions = new int [length * 2 - 1];
        for (int i = 0; i < positions.length; i++)
            positions[i] = -1;
    }
    
    public int nPositions() { return positions.length; }
    public int roomPosition() { return roomPosition; }
    
    public int getThiefIn (int pos) { return positions[pos]; }
    
    public boolean isFree(int pos) {
        return positions[pos] == -1;
    }
    
    public void occupy (int pos, int thiefId) {
        assert isFree(pos) : "Position is already occupied";
        
        this.positions[pos] = thiefId;
    }
    
    public void free (int pos) {
        assert !isFree(pos) : "Position is not occupied";
        
        this.positions[pos] = -1;
    }
    
}
