package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ExampleSubsystem {

    /**
     * The state variable controls the state machine which controls what actions 
     * occurs.
     */
    private static int state = 0;
    private static boolean exampleBool = false;
    private static double exampleLimit = 1.0;

    /**
     * This function contains initialization code for this specific subsystem.
     * 
     * Initializes variables and any other things neceassary.
     */
    public static void init() {
        state = 0;
        exampleBool = false;

    }

    /**
     * The determinator function changes the state variable depending on conditions 
     * (these include the push of a button, a change of a boolean, etc.) 
     */
    public static void determ() {
        if (exampleBool) {
            state = 2;
        }
    }

    /**
     * This function contains code to be run periodically for this specific subsystem.
     * 
     * Contains the determinator (determ()) to make sure that states stay updated how they should.
     * 
     * Contains sdbUpdate() to allow things to be put up on the SmartDashboard and allows any
     * updatable dashboard variable to stay updated.
     * 
     * Contains the state machine which is a switch-case that does certain 
     * actions based on the state variable.
     * 
     */
    public static void update() {
        determ();
        sdbUpdate();
        
        /**
         * The state machine, each case contains a different action
         */
        switch (state) {
            case 0: //Usually a state where everything is off

                cmdUpdate(0.0);
                state++; //This propels the state machine to the next case (it makes state = 1).

                break;

            case 1: //This state does something, then makes exampleBool true, to propel it to the next state thanks to determ()

                cmdUpdate(1.0);

                exampleBool = true; //(usually there would be a condition to make exampleBool true, like driving for an amount of time)

                break;
            case 2:

                cmdUpdate(0.5);

                break;
            default: //Default case exists in case state becomes a number that is not possible, it turns things off
                cmdUpdate(0.0);

                break;
        }

    }

    /**
     * This function contains the control for actual physical components (parameter can be motor speed or 
     * solenoid action or similar). It also contains safeties to assure that any physical components 
     * don't get damaged.
     */
    public static void cmdUpdate(double parameter) {

        if (parameter <= exampleLimit) { //makes sure that the parameter stays under a limit

        } else {

        }
    }

    /**
     * Contains variables to be put up on SmartDashboard
     */
    public static void sdbUpdate() {
        SmartDashboard.putNumber("state", state);
        SmartDashboard.putBoolean("exampleBoolean", exampleBool);
    }

    /**
     * Methods to return variables
     */
    public static int getState() {
        return state; 
    }

    public static boolean getBool() {
        return exampleBool;
    }





}