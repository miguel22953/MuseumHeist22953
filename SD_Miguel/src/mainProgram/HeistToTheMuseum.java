/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainProgram;

import interfaces.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import logger.LogMessage;
import logger.LogWriter;
import monitors.*;
import monitors.SharedMem.Type;
import viewer.IDrawViewer;
import viewer.IDrawable;
import viewer.SimViewer;
import viewer.messages.ViewerMessage;

/**
 *
 * @author Miguel
 */
public class HeistToTheMuseum extends Thread {
    
    private SimViewer viewer;
    private SharedMem<LogMessage> logger;
    private Outside outside;
    private Repository repository;
    private SharedPath [] paths;
    private SharedRoom [] rooms;
    
    private MasterThread masterThr;
    private Thread [] thieves;
    
    private LogWriter logWriter;
    
    public HeistToTheMuseum (SimViewer view) {
        
        this.viewer = view;
        this.logger = new SharedMem(Type.FIFO, 50);
        this.repository = new Repository((IWritable<LogMessage>) logger, (IDrawable) viewer);
        this.outside = new Outside ((IOutsideReport) repository);
        this.paths = new SharedPath[Params.nRooms()];
        this.rooms = new SharedRoom[Params.nRooms()];
        
        for (int roomId = 0; roomId < Params.nRooms(); roomId++) {
            this.paths[roomId] = new SharedPath(Params.distances()[roomId], (IPathReport) repository);
            this.rooms[roomId] = new SharedRoom(roomId, Params.nCanvases()[roomId], (IRoomReport) repository);
        }
        
        this.masterThr = new MasterThread((IMasterOutside) outside);
        this.thieves = new Thread[Params.nThieves()];
        
        for (int thiefId = 0; thiefId < Params.nThieves(); thiefId++) {
            thieves[thiefId] = new Thread(new ThiefThread(thiefId, Params.speeds()[thiefId], (IThiefOutside) outside, (IThiefPath []) paths, (IThiefRoom []) rooms));
        }
        
        this.logWriter = new LogWriter("log.txt", (IReadable<LogMessage>) logger);
    }
    
    @Override
    public void run () {
        logWriter.start();
        for (int thiefId = 0; thiefId < Params.nThieves(); thiefId++)
            thieves[thiefId].start();
        masterThr.start();
        try {
            masterThr.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HeistToTheMuseum.class.getName()).log(Level.SEVERE, null, ex);
        }
        logWriter.stopWriting();
    }
    
}
