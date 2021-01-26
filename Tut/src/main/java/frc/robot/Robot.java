/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Description:
 * This is the main class of the robot program.
 */
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.io.hardware.IO;
import frc.robot.io.hardware.hdw_util.Limelight;
import frc.robot.io.joysticks.JS_IO;
import frc.robot.subsystems.*;
import frc.robot.subsystems.drive.Drive;
import edu.wpi.first.wpilibj.Relay;

public class Robot extends TimedRobot {

  /**
   * This function is run when the robot is first started up and should be used
   * for any overarching initialization code.
   */
  @Override
  public void robotInit() {
    IO.init();
    JS_IO.init();

    Limelight.init();
  }

  /**
   * This function is run periodically all the time while the robot is on.
   */
  @Override
  public void robotPeriodic() {
    IO.update();
    JS_IO.update();

    Limelight.sdbUpdate();

    IO.compressorRelay.set(IO.compressor.enabled() ? Relay.Value.kForward : Relay.Value.kOff);

  }

  /**
   * This function is run when autonomous is first started up and should be used
   * for any autonomous initialization code.
   * 
   * Autonomous = the period of time where the robot is controlled fully by code.
   */
  @Override
  public void autonomousInit() {
  }

  /**
   * This function is run periodically during the autonmous period and should
   * contain all the code to control the robot autonomously.
   */
  @Override
  public void autonomousPeriodic() {
  }

  /**
   * This function is run when the teleop is first started up and should be used
   * for any telop initialization code.
   * 
   * Teleop = Teleoperated, the period where the driver takes control of the
   * robot.
   */
  @Override
  public void teleopInit() {

    // Actually applies the initialization code within init()
    ExampleSubsystem.init();
    Drive.init();

  }

  /**
   * This function is run periodically during the teleop period and should contain
   * all the code to allow the driver to control the robot.
   */
  @Override
  public void teleopPeriodic() {
    // Actually assures the code for controlling this subsystem works as it should
    ExampleSubsystem.update();
    Drive.update();
  }

  /**
   * This function is run when the robot is disabled and should be used for any
   * initialization code for when the robot is disabled.
   * 
   * ~Currently not used by TR~
   */
  @Override
  public void disabledInit() {
  }

  /**
   * This function is run periodically all the time while the robot is disabled.
   * 
   * ~Currently not used by TR~
   */
  @Override
  public void disabledPeriodic() {
  }

  /**
   * This function is run when the test mode is first started up and should be
   * used for any test mode initialization code.
   * 
   * Test mode is a special mode for.... testing (allows for some changes in the
   * Driver Station).
   */
  @Override
  public void testInit() {
  }

  /**
   * This function is run periodically in test mode and should contain all and any
   * test code.
   */
  @Override
  public void testPeriodic() {
  }

}
