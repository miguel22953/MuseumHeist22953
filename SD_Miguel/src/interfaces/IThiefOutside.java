/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Canvas;
import exceptions.OutsideException;

/**
 *
 * @author Miguel
 */
public interface IThiefOutside {
    boolean amINeeded(int thiefId);
    int prepareExcursion(int thiefId);
    void handACanvas(int thiefId, Canvas canvas) throws OutsideException;
}
