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
public final class EraseMessage extends ViewerMessage {
    public EraseMessage (Drawing draw, int x, int y, int layer) {
        super(draw, x, y, layer);
        this.action = Action.ERASE;
    }
    
}
