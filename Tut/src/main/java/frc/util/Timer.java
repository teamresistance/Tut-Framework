package frc.util;

/** 
 * Author: Anthony
 * 
 * Revisions: Anthony - 1/1/20 - Released
 *            JCH - 3/12/20 - JCH added simple startTimer and renamed variables.
 * 
 * Descriptions:
 * The timer class allows for the creation of a timer that can be defined by 
 * an external variable or just by the initially defined delay.
*/

public class Timer {

    private double delay; //in seconds
    private double initTime;

    /**
     * COV = change of variable
     * 
     * Triggers are variables that start the actual count toward the delay
     */
    private int covTrgr = -1;
    private boolean trgr = false;

    //Constructor
    public Timer(double delay){
        initTime = System.currentTimeMillis();
        this.delay = delay * 1000;
    }

    // If a certain int variable changes: set delay time once, then continue to call for expired time.
    public boolean hasExpired(double delay, int covTrgr){
        if(this.covTrgr != covTrgr){
            initTime = System.currentTimeMillis();
            this.delay = delay * 1000;
        }
        this.covTrgr = covTrgr;
        return hasExpired();
    }

    // If a certain boolean variable changes: set delay time once, then continue to call for expired time.
    public boolean hasExpired(double delay, boolean trgr){
        if(this.trgr != trgr){
            initTime = System.currentTimeMillis();
            this.delay = delay * 1000;
        } 
        this.trgr = trgr;
        return hasExpired();
    }

    // Has present time exceed delay time.
    public boolean hasExpired(){
        return System.currentTimeMillis() >= (initTime + delay);
    }

    // Resets the timer and sets a new delay
    public void startTimer(double sec){
        delay = sec;
        initTime = System.currentTimeMillis();
    }

    // Resets the timer and uses existing delay
    public void startTimer(){
        initTime = System.currentTimeMillis();
    }

}