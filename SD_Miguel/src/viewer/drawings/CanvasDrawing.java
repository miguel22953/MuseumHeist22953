/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer.drawings;

import java.awt.Color;

/**
 *
 * @author Miguel
 */
public class CanvasDrawing extends Drawing {
    public CanvasDrawing (int nCanvas) {
        super(String.valueOf(nCanvas), Color.BLACK, 2, 1);
    }
}
