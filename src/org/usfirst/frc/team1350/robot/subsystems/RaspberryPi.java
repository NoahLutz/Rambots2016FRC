package org.usfirst.frc.team1350.robot.subsystems;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.Robot;
import org.usfirst.frc.team1350.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RaspberryPi extends Subsystem {
    
	//Singleton
	private static RaspberryPi instance;
	public RaspberryPi getInstance(){
		if (instance==null){
			instance = new RaspberryPi();
		}
		return instance;
	}
	
    public void init(){
    	Log.info("Initalizing RPi");
//    	Robot.oi.camera1.set(true);
    }
    
    public boolean switchToCamera(int camera){
    	turnOffCameras();
    	switch (camera){
    	case RobotMap.RPI_CAMERA_SET1:
    		Log.info("Switched to Camera1");
    		Robot.oi.camera1.set(true);
    		break;
    	case RobotMap.RPI_CAMERA_SET2:
    		Log.info("Switched to Camera2");
    		Robot.oi.camera2.set(true);
    		break;
    	}
    	return true;
    }
    
    public void turnOffCameras(){
    	Robot.oi.camera1.set(false);
    	Robot.oi.camera2.set(false);
    }


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

