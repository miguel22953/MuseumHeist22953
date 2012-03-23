/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package viewer;

/**
 *
 * @author Miguel
 */
public class SimDrawer extends Thread {
    
    public SimDrawer (IDrawViewer viewer) {
        this.viewer = viewer;
    }
    
    @Override
    public void run () {
        while (true) {
            viewer.drawNext();
        }
    }
    
    private IDrawViewer viewer;
}
