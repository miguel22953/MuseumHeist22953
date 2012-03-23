/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer.messages;

import viewer.drawings.Drawing;

/**
 *
 * @author Miguel
 */
public final class MoveMessage extends ViewerMessage {
    public MoveMessage (Drawing draw, int lastX, int lastY, int lastLayer, int x, int y, int layer) {
        super(draw, x, y, layer);
        this.action = Action.MOVE;
        this.lastX = lastX;
        this.lastY = lastY;
        this.lastLayer = lastLayer;
    }
    
    public int lastX() { return lastX; }
    public int lastY() { return lastY; }
    public int lastLayer() { return lastLayer; }
    
    private int lastX;
    private int lastY;
    private int lastLayer;
}
