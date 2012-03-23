/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainProgram;

import classes.Canvas;
import classes.OrdinaryThief;
import exceptions.OutsideException;
import interfaces.IThiefOutside;
import interfaces.IThiefPath;
import interfaces.IThiefRoom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class ThiefThread extends OrdinaryThief implements Runnable {
    
    private IThiefOutside outside;
    private IThiefPath [] paths;
    private IThiefRoom [] rooms;
    
    public ThiefThread(int id, int speed, IThiefOutside outside, IThiefPath [] paths, IThiefRoom [] rooms) {
        super (id, speed);
        this.outside = outside;
        this.paths = paths;
        this.rooms = rooms;
    }
    
    @Override
    public void run() {
        while (outside.amINeeded(id))
        {
            prepareExcursion();
            while (paths[roomId].crawlOut(this)) {}
            Canvas c = rooms[roomId].rollACanvas(id);
            reverseDirection();
            while(paths[roomId].crawlIn(this)) {}
            try {
                outside.handACanvas(id, c);
            } catch (OutsideException ex) {
                Logger.getLogger(ThiefThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void prepareExcursion() {
        this.roomId = outside.prepareExcursion(id);
        paths[roomId].waitOutside(id);
    }
    private void reverseDirection() {
        this.direction = CRAWLIN;
    }
}
