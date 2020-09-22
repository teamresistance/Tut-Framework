package frc.robot.io.hdw_util;

/**
 * TODO: author
 * Author: 
 * 
 * Revisions: JCH - 11/19/19 - Modifications to normalized and getNormalized
 * 
 * Description:
 * This class allows for the creation of the NavX object, which allows 
 * gyro output to be used.   
 */

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

public class NavX {
	// Declare a variable using SPI connector
	public AHRS ahrs = new AHRS(SPI.Port.kMXP);

	// Returns actual Z position
	public double getAngle() {
		return ahrs.getAngle();
	}

	// Returns a normalized Z position between 0 and 360 degrees
	public double normalizedAngle(double angle) {
		return ((angle % 360) + 360) % 360;
	}

	// Returns a normalized Z position between 0 and 360 degrees
	public double getNormalizedAngle() {
		return (normalizedAngle(ahrs.getAngle()));
	}

	// Resets Gyro to 0 degrees.
	public void reset() {
		ahrs.reset();
	}

	// Returns variable
	public AHRS getAHRS() {
		return ahrs;
	}

}