package frc.io.joysticks;
/*
Original Author: Joey & Anthony
Rewite Author: Jim Hofmann
History:
J&A - 11/6/2019 - Original Release
JCH - 11/6/2019 - Original rework
TODO: Exception for bad or unattached devices.
      Auto config based on attached devices and position?
      Add enum for jsID & BtnID?  Button(eLJS, eBtn6) or Button(eGP, eBtnA)
Desc: Reads joystick (gamePad) values.  Can be used for different stick configurations
    based on feedback from Smartdashboard.  Various feedbacks from a joystick are
    implemented in classes, Button, Axis & Pov.
    This version is using named joysticks to istantiate axis, buttons & axis
*/

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.io.joysticks.js_util.*;

/**
 * Similar to IO, JS_IO stores all of the buttons and axis on the Xbox
 * controller/Joystick setup (organized by subsystem) so that buttons and JS
 * axes can be used to control certain things in code.
 */

public class JS_IO {
    /**
     * jsConfig is a variable which is updated in SmartDashboard that controls which
     * control style is being used.
     * 
     * 0=Joysticks, 1=gamePad only
     */
    public static int jsConfig = 1;

    // All possible joysticks are declared
    public static Joystick leftJoystick = new Joystick(0); // Left JS
    public static Joystick rightJoystick = new Joystick(1); // Right JS
    public static Joystick coJoystick = new Joystick(2); // Co-Dvr JS
    public static Joystick gamePad = new Joystick(3); // Xbox Controller

    /**
     * Each subsystem has its own axes and buttons, which are then assigned real,
     * physical values later.
     */

    // Drive
    public static Axis leftDrive = new Axis();
    public static Axis rightDrive = new Axis();

    // ExampleSubsystem
    public static Axis exampleAxis = new Axis();
    public static Button exampleButton = new Button();

    // Constructor
    public JS_IO() {
        init();
    }

    /**
     * Used for initialization of configJS()
     */
    public static void init() {
        SmartDashboard.putNumber("JS_Config", jsConfig);
        configJS();
    }

    /**
     * Periodically checks for any changes to jsConfig to change the control scheme
     * or not.
     */

    public static void update() {
        if (jsConfig != SmartDashboard.getNumber("JS_Config", 0)) {
            jsConfig = (int) SmartDashboard.getNumber("JS_Config", 0);
            CaseDefault();
            configJS();
        }
    }

    /**
     * This function is what changes the control scheme based on jsConfig
     */
    public static void configJS() { // Default Joystick else as gamepad
        jsConfig = (int) SmartDashboard.getNumber("JS_Config", 0);

        switch (jsConfig) {
            case 0: // Normal 3 joystick config
                Norm3JS();
                break;

            case 1: // Gamepad only
                A_GP();
                break;

            default: // Bad assignment
                // CaseDefault();
                break;

        }
    }

    // ================ Controller actions ================
    /**
     * These functions contain the assignments of certain buttons and axes to their
     * physical locations for each control scheme.
     */

    // ----------- Normal 3 Joysticks -------------
    private static void Norm3JS() {
        leftDrive.setAxis(leftJoystick, 1);
        rightDrive.setAxis(rightJoystick, 1);

        exampleAxis.setAxis(coJoystick, 1);
        exampleButton.setButton(coJoystick, 4);
    }

    // ----- gamePad only --------
    private static void A_GP() {
        leftDrive.setAxis(gamePad, 1);
        rightDrive.setAxis(gamePad, 2);

        exampleAxis.setAxis(gamePad, 3);
        exampleButton.setButton(coJoystick, 4);
    }

    // ----------- Case Default -----------------
    // All axes are set to null in default, as a back up just in case jsConfig
    // becomes a number that is not "defined" in configJS()
    private static void CaseDefault() {

        // All stick axisesssss
        leftDrive.setAxis(null, 0);
        rightDrive.setAxis(null, 0);
        exampleAxis.setAxis(null, 0);
    }
}