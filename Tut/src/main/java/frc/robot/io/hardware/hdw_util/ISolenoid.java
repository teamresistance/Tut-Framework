package frc.robot.io.hardware.hdw_util;

/**
 * This is an interface for InvertibleSolenoid.
 */

public interface ISolenoid {
	
	public void set(boolean state);
	public boolean get();
}