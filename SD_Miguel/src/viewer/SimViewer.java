/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer;

import classes.Room;
import classes.memories.MemException;
import classes.memories.MemFIFO;
import genclass.GenericIO;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainProgram.Params;
import pt.ua.gboard.FilledGelem;
import pt.ua.gboard.GBoard;
import pt.ua.gboard.StringGelem;
import viewer.drawings.CanvasDrawing;
import viewer.drawings.Drawing;
import viewer.messages.ViewerMessage;
import viewer.messages.MoveMessage;

/**
 *
 * @author Miguel
 */
public class SimViewer implements IDrawViewer, IDrawable {
    
    private GBoard board;
    private MemFIFO<ViewerMessage> drawings;
    
    public SimViewer (GBoard board) {
        
        this.drawings = new MemFIFO(50);
        this.board = board;
        
    }
    
    @Override
    public synchronized void drawNext () {
        while (drawings.isEmpty())
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SimViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        ViewerMessage drawing = null;
        try {
            drawing = drawings.read();
        } catch (MemException ex) {
            Logger.getLogger(SimViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        int line = drawing.x();
        int column = drawing.y();
        int layer = drawing.layer();
        switch (drawing.action()) {
            case DRAW:
                if (board.exists(line, column, layer))
                    board.erase(line, column, layer, layer);
                board.draw(drawing.getDraw(), drawing.x(), drawing.y(), drawing.layer());
                break;
            case MOVE:
                MoveMessage d = (MoveMessage) drawing;
                board.move(d.getDraw(), d.lastX(), d.lastY(), d.lastLayer(), d.x(), d.y(), d.layer());
                break;
            case ERASE:
                board.erase(drawing.getDraw(), drawing.x(), drawing.y(), drawing.layer());
        }
        notifyAll();
    }
    @Override
    public synchronized void sendDraw (ViewerMessage drawing) {
        while (drawings.isFull())
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SimViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            drawings.write(drawing);
        } catch (MemException ex) {
            Logger.getLogger(SimViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        notifyAll();
    }
    
}
