/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer.drawings;

import java.awt.Color;
import pt.ua.gboard.StringGelem;

/**
 *
 * @author Miguel
 */
abstract public class Drawing extends StringGelem {
    
    protected Drawing (String text, Color color) {
        this(text, color, 1, 1);
    }
    protected Drawing (String text, Color color, int nRows, int nCols) {
        super(text, color, nRows, nCols);
    }
}
