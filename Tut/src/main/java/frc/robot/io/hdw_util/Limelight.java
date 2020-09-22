package frc.robot.io.hdw_util;

/**
 * Author: Kinfe 
 * 
 * TODO: date
 * Revisions: JCH - _____ - new method llOnTarget for deadband targeting
 * 
 * Description: 
 * This class contains functions that allow the output of the Limelight to be used in subsystems, as well
 * as outputting the data to the SmartDashboard.
 */

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Limelight {

    private static NetworkTable limeTable = NetworkTableInstance.getDefault().getTable("limelight");
    private static double ledmode = 0, cammode = 0, pipeline = 0;

    /**
     * Initializes the NetworkTable object to receive the data from, as well as sets up
     * options in the SmartDashboard to change any of those three settings.
     */
    public static void init() {
        limeTable = NetworkTableInstance.getDefault().getTable("limelight");
        SmartDashboard.putNumber("led mode", ledmode);
        SmartDashboard.putNumber("cam mode", cammode);
        SmartDashboard.putNumber("pipeline", pipeline);
    }

    // Returns if the Limelight has a valid target in sight
    public static boolean llHasTarget() {
        double valid = limeTable.getEntry("tv").getDouble(0);

        if (valid == 1.0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A hasTarget with a choosable deadband.
     * 
     * Target is: -1 = to the right, 1 = to the left, 0 = on target, and 999 = no
     * target
     */
    public static Integer llOnTarget(double db) {
        double tmpD = getLLX();
        if (llHasTarget()) {
            if (Math.abs(tmpD) > db) {
                return tmpD < 0.0 ? -1 : 1;
            }
            return 0;
        }
        return 999;
    }

    // A default llOnTarget with a deadband of 2
    public static Integer llOnTarget() {
        return llOnTarget(2);
    }

    // Returns X offset
    public static double getLLX() {
        return limeTable.getEntry("tx").getDouble(999);
    }

    // Returns Y offset
    public static double getLLY() {
        return limeTable.getEntry("ty").getDouble(0);
    }

    // Returns the % area that the target is taking up
    public static double getLLArea() {
        return limeTable.getEntry("ta").getDouble(0);
    }

    /**
     * Sets the LED
     * 
     * default of current pipeline (0), off (1), blinking (2), on (3)
     */
    public static void setLED() {
        limeTable.getEntry("ledMode").setNumber(ledmode);
    }

    /**
     * Sets the Camera Mode
     * 
     * vision processing (0) or driver mode (1)
     */
    public static void setCamMode() {
        limeTable.getEntry("camMode").setNumber(cammode);
    }

    // Sets to one of the predefined pipelines
    public static void setPipeline() {
        limeTable.getEntry("pipeline").setNumber(pipeline);
    }

    // Outputs the data to the SmartDashboard
    public static void sdbUpdate() {
        getLLX();
        SmartDashboard.putBoolean("ll has target", llHasTarget());
        SmartDashboard.putNumber("limelight x offset", getLLX());
        SmartDashboard.putNumber("limelight y offset", getLLY());
        SmartDashboard.putNumber("limelight percent area", getLLArea() * 100);

        ledmode = SmartDashboard.getNumber("led mode", ledmode);
        setLED();
        cammode = SmartDashboard.getNumber("cam mode", cammode);
        setCamMode();
        pipeline = SmartDashboard.getNumber("pipeline", pipeline);
        setPipeline();
    }
}