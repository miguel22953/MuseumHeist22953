/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monitors;

import classes.memories.MemException;
import classes.memories.MemFIFO;
import classes.memories.MemObject;
import classes.memories.MemStack;
import interfaces.IReadable;
import interfaces.IWritable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class SharedMem<T> implements IReadable<T>, IWritable<T> {
    public enum Type { FIFO, STACK }
    
    public SharedMem (Type type, int limit) {
        this.type = type;
        switch (type) {
            case FIFO:
                this.mem = new MemFIFO(limit);
                break;
            case STACK:
                this.mem = new MemStack(limit);
        }
    }
    
    @Override
    public synchronized T read () {
        while (mem.isEmpty())
            try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(SharedMem.class.getName()).log(Level.SEVERE, null, ex);
        }
        T msg = null;
        try {
            msg = mem.read();
        } catch (MemException ex) {
            Logger.getLogger(SharedMem.class.getName()).log(Level.SEVERE, null, ex);
        }
        notifyAll();
        return msg;
    }
    @Override
    public synchronized void write (T msg) {
        while (mem.isFull())
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(SharedMem.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            mem.write(msg);
        } catch (MemException ex) {
            Logger.getLogger(SharedMem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        notifyAll();
    }
    
    protected MemObject<T> mem;
    protected Type type;
}
