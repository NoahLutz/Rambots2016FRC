package org.usfirst.frc.team1350.robot.subsystems;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.RobotMap;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RangeFinder extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//Singleton
	private static RangeFinder instance;
	public static RangeFinder getInstance(){
		if (instance ==null){
			instance = new RangeFinder();
		}
		return instance;
	}

	private Ultrasonic sensor;
	
	public RangeFinder(){
		Log.info("Initializing RangeFinder");
	}
	
	public void init(){
    	sensor = new Ultrasonic(RobotMap.ULTRASONIC_ECHO_PULSE_OUTPUT, RobotMap.ULTRASONIC_TRIGGER_PULSE_INPUT);
    	sensor.setAutomaticMode(true);
	}
	
	public double getRange(){
		return sensor.getRangeInches();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//TODO: add default command
    }
}

