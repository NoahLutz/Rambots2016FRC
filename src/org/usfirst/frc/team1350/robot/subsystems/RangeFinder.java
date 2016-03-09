package org.usfirst.frc.team1350.robot.subsystems;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.RobotMap;
import org.usfirst.frc.team1350.robot.commands.FindRange;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RangeFinder extends Subsystem {
    
	//Singleton
	private static RangeFinder instance;
	public static RangeFinder getInstance(){
		if (instance ==null){
			instance = new RangeFinder();
		}
		return instance;
	}

	//TODO test and adjust
	private final float PWM_MULTIPLIER = 147f;

	private PWM rangeFinder;
	
	public RangeFinder(){
		Log.info("Initialize RangeFinder");
	}
	
	public void init(){
		rangeFinder = new PWM(RobotMap.RANGEFINDER_PORT);
	}
	
	public float getRange(){
		return (float) (rangeFinder.getRaw() * PWM_MULTIPLIER);
	}
	
	public float getRaw(){
		return (float) (rangeFinder.getRaw());
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new FindRange());
    }
}

