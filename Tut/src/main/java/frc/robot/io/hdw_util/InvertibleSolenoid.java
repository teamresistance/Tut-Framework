package frc.robot.io.hdw_util;

/**
 * TODO: Find Author and any revisions
 * Author:
 * 
 * Revisions:
 * 
 * Description: 
 * This class allows for the creation of objects that represent invertible solenoids.
 */

import edu.wpi.first.wpilibj.Solenoid;

public class InvertibleSolenoid extends Solenoid implements ISolenoid {

    private final boolean isInverted;

    // Default Solenoid Constructor, not inverted
    public InvertibleSolenoid(int module, int channel) {
        this(module, channel, false);
    }
    // Constructor to Makes Solenoid Object
    public InvertibleSolenoid(int module, int channel, boolean isInverted) {
        super(module, channel);
        this.isInverted = isInverted;
    }

    //This activates the Solenoid (extends or retracts)
    @Override
    public void set(boolean state) {
        if (isInverted) {
            super.set(!state);
        } else {
            super.set(state);
        }
    }

    //This returns the state of the Solenoid (extended or not)
    public boolean get(){
        return (isInverted ? !super.get() : super.get());
    }

}