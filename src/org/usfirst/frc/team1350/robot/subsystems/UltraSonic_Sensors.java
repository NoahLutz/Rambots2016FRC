package org.usfirst.frc.team1350.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class UltraSonic_Sensors extends CommandGroup {
    
    public  UltraSonic_Sensors() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	//Creating an ultrasonic object 
    	Ultrasonic ultra = new Ultrasonic(ULTRASONIC_ECHO_PULSE_OUTPUT, ULTRASONIC_TRIGGER_PULSE_INPUT);
    	
    	
    	//reading the distance 
    	Ultrasonic ultra = new UltrasonicRobotMap.(ULTRASONIC_PING, ULTRASONIC_ECHO);
    	ultra.setAutomaticMode(true);
    	int range = (int) ultra.getRangeInches();
    	
    	/*
    	 * Many ultrasonic rangefinders return the range as an analog voltage. 
    	 * To get the distance you multiply the analog voltage by the sensitivity 
    	 * or scale factor (typically in inches/V or inches/mV).
    	 * 
    	 */
    }
}
