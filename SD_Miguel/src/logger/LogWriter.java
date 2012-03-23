/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logger;

import genclass.GenericIO;
import genclass.TextFile;
import interfaces.IReadable;
import mainProgram.Params;

/**
 *
 * @author Miguel
 */
public class LogWriter extends Thread {
    public LogWriter (String fileName, IReadable<LogMessage> logger) {
        this.fileName = fileName;
        this.logger = logger;
    }
    
    @Override
    public void run() {
        LogMessage msg;
        if (!logFile.openForAppending (".", fileName))
        {
            GenericIO.writelnString ("Failed creating file " + fileName);
            System.exit (1);
        }
        
        logFile.writelnString("HEIST TO THE MUSEUM");
        
        while (!stop)
        {
            msg = logger.read();
            
            String lineStatus = String.format("%-4s", msg.getTick());
            lineStatus += String.format("%5s", msg.getMasterStat());
            
            for (int i = 0; i < Params.nThieves(); i++) {
                lineStatus+= " ";
                lineStatus+= String.format("%5s", msg.getThiefStat(i));
                lineStatus+= String.format("%2s", msg.getGroupId(i));
                lineStatus+= String.format("%3s", msg.getPosition(i));
                lineStatus+= String.format("%4s", msg.hasCanvas(i));
            }
            for (int i = 0; i < Params.nGroups(); i++) {
                lineStatus+= " ";
                lineStatus+= String.format("%2s", msg.getRoomId(i));
            }
            for (int i = 0; i < Params.nRooms(); i++) {
                lineStatus+= " ";
                lineStatus+= String.format("%3s", msg.getnCanvas(i));
            }
            logFile.writelnString(lineStatus);
      }
      
    }
    
    public void stopWriting() {
        stop = true;
        if (!logFile.close ())
         { GenericIO.writelnString ("Failed closing file " + fileName);
           System.exit (1);
         }
    }
    
    private IReadable<LogMessage> logger;
    private TextFile logFile = new TextFile (); // instanciação de uma variável de tipo ficheiro de texto
    private boolean stop = false;;
    private String fileName = "log.txt";
}
