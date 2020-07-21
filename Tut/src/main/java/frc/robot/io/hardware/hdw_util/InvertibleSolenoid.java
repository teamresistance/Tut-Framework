package frc.robot.io.hardware.hdw_util;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * This class allows for the creation of objects that represent solenoids.
 */

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

    //This activates the Solenoid
    @Override
    public void set(boolean state) {
        if (isInverted) {
            super.set(!state);
        } else {
            super.set(state);
        }
    }

    public boolean get(){
        return (isInverted ? !super.get() : super.get());
    }

}