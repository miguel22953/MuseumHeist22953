/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monitors;

import classes.Canvas;
import classes.Room;
import classes.memories.MemException;
import classes.memories.MemStack;
import interfaces.IRoomReport;
import interfaces.IThiefRoom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class SharedRoom implements IThiefRoom {
    private int roomId;
    private MemStack<Canvas> canvasStack;
    private IRoomReport report;
    
    public SharedRoom (int roomId, int nCanvas, IRoomReport report) {
        this.roomId = roomId;
        this.canvasStack = new MemStack(nCanvas);
        for (int i = 0; i < nCanvas; i++) {
            try {
                canvasStack.write(new Canvas());
            } catch (MemException ex) {
                Logger.getLogger(SharedRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public synchronized Canvas rollACanvas(int thiefId) {
        Canvas c;
        try {
            c = canvasStack.read();
            report.setnCanvas(roomId, canvasStack.size());
            report.setThiefCanvas(thiefId, true);
        } catch (MemException ex) {
            return null;
        }
        return c;
    }
}
