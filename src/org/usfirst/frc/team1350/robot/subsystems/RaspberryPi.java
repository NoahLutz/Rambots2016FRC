package org.usfirst.frc.team1350.robot.subsystems;

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
	
    private DigitalOutput camera1;
    private DigitalOutput camera2;
    private DigitalOutput camera3;
    private DigitalOutput camera4;
    
    
    public void init(){
    	camera1 = new DigitalOutput(RobotMap.RPI_CAMERA1);
    	camera2 = new DigitalOutput(RobotMap.RPI_CAMERA2);
    	camera3 = new DigitalOutput(RobotMap.RPI_CAMERA3);
    	camera4 = new DigitalOutput(RobotMap.RPI_CAMERA4);
    }
    
    public boolean switchToCamera(int camera){
    	turnOffCameras();
    	switch (camera){
    	case RobotMap.RPI_CAMERA1:
    		camera1.set(true);
    		break;
    	case RobotMap.RPI_CAMERA2:
    		camera2.set(true);
    		break;
    	case RobotMap.RPI_CAMERA3:
    		camera3.set(true);
    		break;
    	case RobotMap.RPI_CAMERA4:
    		camera4.set(true);
    		break;
    	}
    	return true;
    }
    
    public void turnOffCameras(){
    	camera1.set(false);
    	camera2.set(false);
    	camera3.set(false);
    	camera4.set(false);

    }


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

