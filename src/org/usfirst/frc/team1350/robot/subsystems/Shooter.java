package org.usfirst.frc.team1350.robot.subsystems;

import org.usfirst.frc.team1350.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//singleton
	private static Shooter instance;
	public Shooter getInsatnce(){
		if (instance==null){
			instance = new Shooter();
		}
		return instance;
	}

	private Victor leftLauncherMotorController;
	private Victor rightLauncherMotorController;
	
	private Talon leftTiltMotorController;
	private Talon rightTiltMotorController;
	
	//TODO: create electric solenoid thingy
	
	public void init(){
		leftLauncherMotorController = new Victor(RobotMap.SHOOTER_LEFT_MOTOR_CONTROLLER);
		rightLauncherMotorController = new Victor(RobotMap.SHOOTER_RIGHT_MOTOR_CONTROLLER);
		
		leftTiltMotorController = new Talon(RobotMap.SHOOTER_TILT_LEFT_MOTOR_CONTROLLER);
		rightTiltMotorController = new Talon(RobotMap.SHOOTER_TILT_RIGHT_MOTOR_CONTROLLER);
		
		//TODO: initialize solenoid thingy
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

