package frc.robot.io.hardware.hdw_util;

/**
 * TODO: Find Author and any revisions 
 * 
 * Author:
 * 
 * Revisions:
 * 
 * Description: This is an interface implemented in InvertibleSolenoid.
 */

public interface ISolenoid {

	public void set(boolean state);

	public boolean get();
}