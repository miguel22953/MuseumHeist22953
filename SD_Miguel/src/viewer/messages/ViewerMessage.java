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
public abstract class ViewerMessage {
    
    public enum Action { DRAW, MOVE, ERASE }
    
    public ViewerMessage (Drawing draw, int x, int y, int layer) {
        this.drawing = draw;
        this.x = x;
        this.y = y;
        this.layer = layer;
        this.action = Action.DRAW;
    }
    
    public Drawing getDraw () { return drawing; }
    public int x() { return x; }
    public int y() { return y; }
    public int layer() { return layer; }
    public Action action() { return action; }
    
    protected Drawing drawing;
    protected int x;
    protected int y;
    protected int layer;
    protected Action action;
}
