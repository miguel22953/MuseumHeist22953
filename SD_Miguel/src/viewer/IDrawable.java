/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer;

import viewer.messages.ViewerMessage;

/**
 *
 * @author Miguel
 */
public interface IDrawable {
    void sendDraw(ViewerMessage drawing);
}
