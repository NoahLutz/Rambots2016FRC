package org.usfirst.frc.team1350.robot.subsystems;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.RobotMap;
import org.usfirst.frc.team1350.robot.commands.FindRange;
import org.usfirst.frc.team1350.robot.utils.Utils;

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

	private AnalogInput rangeFinder;
	
	public RangeFinder(){
		Log.info("Initialize RangeFinder");
		rangeFinder = new AnalogInput(RobotMap.RANGEFINDER_PORT);
	}
	
	public void init(){
	}
	
	public float getRange(){
		float mm = (float) ((rangeFinder.getVoltage()*1000)/.977);
		//Log.info("Metric: " + mm);
		return mm;
	}
	
	public float getRaw(){
		return (float) (rangeFinder.getVoltage());
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new FindRange());
    }
}

