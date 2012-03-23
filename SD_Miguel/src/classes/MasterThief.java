/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.memories.MemException;
import classes.memories.MemStack;

/**
 *
 * @author Miguel
 */
public class MasterThief {

    public enum Status {
        PLANNING_THE_HEIST,
        DECIDING_WHAT_TO_DO,
        ASSEMBLING_A_GROUP,
        WAITING_FOR_GROUP_ARRIVAL,
        PRESENTING_THE_REPORT;
        
        @Override
        public String toString() {
            switch (this) {
                case PLANNING_THE_HEIST:
                    return "PLANN";
                case DECIDING_WHAT_TO_DO:
                    return "DECID";
                case ASSEMBLING_A_GROUP:
                    return "ASSEM";
                case WAITING_FOR_GROUP_ARRIVAL:
                    return "WAITA";
                case PRESENTING_THE_REPORT:
                    return "REPOR";
                default:
                    return "-----";
            }
        }
    }
    
    protected Status status;
    private MemStack<Canvas> canvasStack = null;
    
    public final Status getStatus() {
        return status;
    }
    public final void setStatus(Status status) {
        this.status = status;
    }
    
    /**
     * @return the canvasStack
     */
    public MemStack<Canvas> getCanvasStack() {
        return canvasStack;
    }
}
