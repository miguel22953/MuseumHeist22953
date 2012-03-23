/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainProgram;

/**
 *
 * @author Miguel
 */
public final class Params {
    public static final int DEFAULT_TOTAL_THIEVES = 7;
    public static final int DEFAULT_GROUP_SIZE = 3;
    public static final int DEFAULT_MIN_SPEED = 1;
    public static final int DEFAULT_MAX_SPEED = 5;
    public static final int DEFAULT_MAX_GAP = 4;
    public static final int DEFAULT_N_ROOMS = 5;
    public static final int DEFAULT_MIN_DISTANCE = 5;
    public static final int DEFAULT_MAX_DISTANCE = 20;
    public static final int DEFAULT_TOTAL_CANVASES = 50;
    
    public static int SIM_SPEED = 50;

    
    private static int nThieves;
    private static int groupSize;
    private static int maxGap;
    private static int nRooms;
    private static int totalCanvases;
    private static int [] distances;
    private static int [] nCanvases;
    private static int [] speeds;
    
    private Params () {}
    
    public static void setParams(int totalTh, int gSize, int minSp, int maxSp, int gap, int nRooms, int minDist, int maxDist, int nCanv) {
        assert totalTh > 1 : "Invalid number of thieves";
        assert gSize > 1 : "Invalid group size";
        assert (totalTh - 1) % gSize == 0 : "Number of thieves incompatible with group size";
        assert minSp > 0 && maxSp >= minSp : "Invalid thieves speed";
        assert gap >= 0 : "Invalid gap between consecutive thieves";
        assert nRooms > 0 : "Invalid number of rooms";
        assert minDist > 0 && maxDist >= minDist : "Invalid room distance";
        assert nCanv >= 0 : "Invalid number of canvases";
        
        Params.nThieves = totalTh - 1;
        Params.groupSize = gSize;
        Params.maxGap = gap;
        Params.nRooms = nRooms;
        Params.totalCanvases = nCanv;
        Params.distances = new int[nRooms];
        Params.nCanvases = new int[nRooms];
        Params.speeds = new int[nThieves];
        
        int nCanvasLeft = totalCanvases();
        for (int i = 0; i < nRooms; i++) {
            Params.distances[i] = minDist + (int) (Math.random() * (maxDist - minDist));
            int nCanvas = (int) (Math.random() * nCanvasLeft);
            nCanvasLeft -= nCanvas;
            if (nCanvasLeft < 0) nCanvasLeft = 0;
            Params.nCanvases[i] = nCanvas;
        }
        
        Params.speeds = new int[nThieves()];
        for (int i = 0; i < nThieves(); i++)
            Params.speeds[i] = minSp + (int) (Math.random() * (maxSp - minSp));
    }
    
    /**
     * @return the number of Thieves
     */
    public static int nThieves() {
        return nThieves;
    }
    
    /**
     * @return the groupSize
     */
    public static int groupSize() {
        return groupSize;
    }
    
    public static int nGroups() {
        return nThieves() / groupSize();
    }

    /**
     * @return the maxGap
     */
    public static int maxGap() {
        return maxGap;
    }

    /**
     * @return the nRooms
     */
    public static int nRooms() {
        return nRooms;
    }
    
    /**
     * @return the nCanvases
     */
    public static int totalCanvases() {
        return totalCanvases;
    }
    
    /**
     * @return the distances
     */
    public static int[] distances() {
        return distances;
    }

    /**
     * @return the nCanvases
     */
    public static int[] nCanvases() {
        return nCanvases;
    }

    /**
     * @return the speeds
     */
    public static int[] speeds() {
        return speeds;
    }
    
}
