package frc.io.hardware;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

public class NavX {
	//Declare a variable using SPI connector 
	public AHRS ahrs = new AHRS(SPI.Port.kMXP);
	
	//Returns actual Z position
	public double getAngle() {
		return ahrs.getAngle();
	}
	//Returns a normalized Z position between 0 and 360 degrees - mod jch 11/19/19
	public double normalizedAngle( double angle ) {
		return ((angle %  360) + 360) % 360;
	}
	//Returns a normalized Z position between 0 and 360 degrees - mod jch 11/19/19
	public double getNormalizedAngle() {
		return (normalizedAngle(ahrs.getAngle()));
	}
	//Resets Gyro to 0 degrees.
	public void reset() {
		ahrs.reset();
	}
	//Returns variable
	public AHRS getAHRS() {
		return ahrs;
	}

}