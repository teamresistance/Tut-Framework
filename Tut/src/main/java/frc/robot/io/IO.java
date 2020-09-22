package frc.robot.io;

/**
 * TODO: author and revisions
 * Author:
 * 
 * Revisions:
 * 
 * Description:
 * IO stores all of the objects that represent physical components of the robot,
 * organized by subsystem or purpose.
 */

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Relay;
import frc.robot.io.hdw_util.*;

public class IO {

    // NavX
    public static NavX navX = new NavX();

    // PDP
    public static PowerDistributionPanel pdp = new PowerDistributionPanel(21);

    // Air
    public static Compressor compressor = new Compressor(22);
    public static Relay compressorRelay = new Relay(0);

    // Drive, drive motors are usually stored/created in this section
    public static TalonSRX left = new TalonSRX(0);
    public static TalonSRX right = new TalonSRX(1);

    // ExampleSubsystem, all sensors, motors, etc. for this subsystem are
    // created/stored here
    public static ISolenoid exampleSole = new InvertibleSolenoid(22, 4);
    public static TalonSRX exampleTalon = new TalonSRX(3);
    public static InvertibleDigitalInput exampleSensor = new InvertibleDigitalInput(0, false);

    /**
     * Used for any necessary initialization of any of these components.
     */
    public static void init() {

    }

    /**
     * Used for any necessary periodic update of any of these components.
     */
    public static void update() {

    }
}