package frc.robot.io.js_util;

/**
 * Original Author: Shreya
 * Rewite Author: Jim Hofmann
 * 
 * Revisions: JCH - 11/6/2019 - rework
 *            S - 3/6/2017 - Original release
 * 
 * Description:
 * This class allows for the creation of an object to represent a button on a
 * joystick or gamepad.
 * 
 * Also, allows use of various joystick/gamepad configurations because a Button object can be 
 * any type of button on a joystick/gamepad.
 * 
 * Constructor gets JS_ID and axisID.  However, if the it needs to pass a default (button may not
 * exist for some combinations) then in buttonID pass 100 (even) for true, 101 (odd for false).
 */

import edu.wpi.first.wpilibj.Joystick;

public class Button {

    private Joystick joystick;
    public int buttonID;
    private boolean exists;
    private boolean existDflt;

    // Constructor, normal
    // Exists muxed with axisID, if GT 100 (LT 0) does not exist
    public Button(Joystick injoystick, int inbuttonID) {
        joystick = injoystick;
        buttonID = inbuttonID;
        exists = joystick != null;
        existDflt = buttonID != -1 ? false : true; // default to false, if -1 default to true
    }

    // Constructor, defaults set to does not exist & false
    public Button() {
        exists = false;
        existDflt = false;
    }

    // Constructor, defaults set to does not exist & passed value
    public Button(boolean exDefault) {
        exists = false;
        existDflt = exDefault;
    }

    // assign a new joystick & button
    public void setButton(Joystick injoystick, int inbuttonID) {
        joystick = injoystick;
        buttonID = inbuttonID;
        exists = joystick != null;
        existDflt = buttonID != -1 ? false : true; // default to false, if -1 default to true
    }

    // get current value
    public boolean isDown() {
        return exists ? joystick.getRawButton(buttonID) : existDflt;
    }

    // inverse of the current value
    public boolean isUp() {
        return exists ? !joystick.getRawButton(buttonID) : !existDflt;
    }

    // returns true once when button pressed
    public boolean onButtonPressed() {
        return exists ? joystick.getRawButtonPressed(buttonID) : existDflt;
    }

    // returns true once when button is released
    public boolean onButtonReleased() {
        return exists ? joystick.getRawButtonReleased(buttonID) : existDflt;
    }
}