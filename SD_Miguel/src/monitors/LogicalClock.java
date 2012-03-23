/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monitors;

/**
 *
 * @author Miguel
 */
public class LogicalClock {
    
    private static LogicalClock clock = new LogicalClock();
    private static int tick = 0;
    
    private LogicalClock () {}
    
    public static LogicalClock getClock () { return clock; }
    public static int tick() { return ++tick; }
    public static void reset() { tick = 0; }
}
