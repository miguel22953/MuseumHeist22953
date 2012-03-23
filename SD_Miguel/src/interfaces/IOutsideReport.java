/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.MasterThief;
import classes.OrdinaryThief;

/**
 *
 * @author Miguel
 */
public interface IOutsideReport {
    void setMasterStatus (MasterThief.Status status);
    void setThiefStatus(int thiefId, OrdinaryThief.Status status);
    
}
