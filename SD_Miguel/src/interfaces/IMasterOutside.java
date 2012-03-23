/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import exceptions.OutsideException;

/**
 *
 * @author Miguel
 */
public interface IMasterOutside {
    void startOperations();
    char appraiseSit();
    int prepareAssaultParty() throws OutsideException;
    void sendAssaultParty(int groupId);
    int takeARest() throws OutsideException;
    void collectCanvas(int thiefId) throws OutsideException;
    void sumUpResults();
}
