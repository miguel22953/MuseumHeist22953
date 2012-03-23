/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainProgram;

import exceptions.OutsideException;
import genclass.GenericIO;
import interfaces.IMasterOutside;

/**
 *
 * @author Miguel
 */
public final class MasterThread extends Thread {
    
    private IMasterOutside outside;
    
    public MasterThread(IMasterOutside outside) {
        this.outside = outside;
    }
    
    @Override
    public void run() {
        boolean endOperations = false;
        outside.startOperations();
        while (!endOperations) {
            switch (outside.appraiseSit()) {
                case 'P':
                    int groupId = -1;
                    try {
                        groupId = outside.prepareAssaultParty();
                    } catch (OutsideException ex) {
                        GenericIO.writelnString("Error preparing assault: " + ex);
                        System.exit(-1);
                    }
                    outside.sendAssaultParty(groupId);
                    break;
                case 'W':
                    int thiefId = -1;
                    try {
                        thiefId = outside.takeARest();
                    } catch (OutsideException ex) {
                        GenericIO.writelnString("Error while waiting a thief arrival: " + ex);
                        System.exit(-1);
                    }
                    try {
                        outside.collectCanvas(thiefId);
                    } catch (OutsideException ex) {
                        GenericIO.writelnString("Error collecting a canvas: " + ex);
                        System.exit(-1);
                    }
                    break;
                case 'E':
                    endOperations = true;
            }
        }
        outside.sumUpResults();
    }
    
}
