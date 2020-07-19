package frc.io.hardware;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Relay;

public class IO {
      // navX
      public static NavX navX = new NavX();

      // PDP
      public static PowerDistributionPanel pdp = new PowerDistributionPanel(21);
  
      // Air
      public static Compressor compressor = new Compressor(22);
      public static Relay compressorRelay = new Relay(0);
  
      // Drive
      public static WPI_TalonSRX drvMasterTSRX_L = new WPI_TalonSRX(1);    //Cmds left wheels.  Includes encoders
      public static WPI_TalonSRX drvMasterTSRX_R = new WPI_TalonSRX(5);  //Cmds right wheels.  Includes encoders
      public static final double drvMasterTPF_L = 428.0;   //1024 t/r (0.5' * 3.14)/r 9:60 gr
      public static final double drvMasterTPF_R = 428.0;   //1024 t/r (0.5' * 3.14)/r 9:60 gr
  
      public static WPI_VictorSPX drvFollowerVSPX_L =  new WPI_VictorSPX(2);  //Resrvd 3 & 4 maybe
      public static WPI_VictorSPX drvFollowerVSPX_R = new WPI_VictorSPX(6);  //Resrvd 7 & 8 maybe
  
}