/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Miguel
 */
public class ThreadInterruptedException extends RuntimeException {
    
    public ThreadInterruptedException()
    {
        super();
    }
    
    public ThreadInterruptedException(Throwable t)
    {
        super(t);
    }
    
}
