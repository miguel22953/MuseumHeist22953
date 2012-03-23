/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Miguel
 */
public final class Canvas {
    
    public Canvas () {
        this (nextId++);
    }
    public Canvas (int id) {
        this (id, Math.random()*10000 + 10);
    }
    public Canvas(Canvas c) {
        this(c.id, c.value);
    }
    public Canvas (int id, double value) {
        this.id = id;
        setValue (value);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        assert value >= 0;
        
        this.value = value;
    }
    
    
    private int id;
    private double value;
    private static int nextId = 0;
}
