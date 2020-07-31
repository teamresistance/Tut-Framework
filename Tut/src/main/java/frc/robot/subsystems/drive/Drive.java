package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.io.hardware.IO;
import frc.robot.io.joysticks.JS_IO;

/**
 * Author: Kinfe
 * 
 * Revisions: N/A
 * 
 * Description: Drive is a special subsystem in every robot that controls the movement of the
 * robot. This example shows an extremely simple tank drive control scheme with
 * no additional math other than a scaled (slowed down) drive option.
 * 
 * Drive is still structured the same as other subsystems (ExampleSubsystem explains many of the functions
 * used in Drive). 
 */

public class Drive {

    private static int state = 0;

    /**
     * The scale variable multiplies the input to the motors of the drive, 
     * which overall caps the speed at 50% rather than a full 100%.
     */
    private static double scale = 0.5;

    private static TalonSRX leftTalon = IO.left;
    private static TalonSRX rightTalon = IO.right;

    /**
     * This function contains initialization code for Drive.
     * 
     * Initializes variables and any other things neceassary.
     */
    public static void init() {
        state = 0;
        scale = 0.5;

        cmdUpdate(0,0);
    }

    /**
     * The determinator function changes the state variable depending on conditions.
     * 
     * In drive, when the button represented by scaleDrive is held down, the robot will 
     * scale its driving speed down (state 1 contains the code to do this).
     */
    private static void determ() {
        if (JS_IO.scaleDrive.isDown()) {
            state = 1;
        }
    }

    /**
     * This function contains code to be run periodically for Drive.
     */
    public static void update() {
        sdbUpdate();
        determ();
        switch (state) {
            case 0: // Tank mode, no scaling. Input from JS straight to wheels
                cmdUpdate(-JS_IO.leftDrive.get(), -JS_IO.rightDrive.get());
                break;
            case 1: // Scaled tank driving. Scaled input from Joysticks.
                cmdUpdate(scale * -JS_IO.leftDrive.get(), scale * -JS_IO.rightDrive.get());
                break;
            default:
                cmdUpdate(0.0, 0.0);
                SmartDashboard.putString("INVALID SUBSYSTEM STATE", "INVALID SUBSYSTEM STATE");
                System.out.println("INVALID SUBSYSTEM STATE");
                break;
        }
    }

    private static void cmdUpdate(double leftInput, double rightInput) {
        leftTalon.set(ControlMode.PercentOutput, leftInput);
        rightTalon.set(ControlMode.PercentOutput, -rightInput);
    }

    public static void sdbUpdate() {
        SmartDashboard.putNumber("Driver State", state);
    }

    public static int getState() {
        return state;
    }
}