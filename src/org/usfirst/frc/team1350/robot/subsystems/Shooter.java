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
	public static Shooter getInstance(){
		if (instance==null){
			instance = new Shooter();
		}
		return instance;
	}

	public final boolean FORWARD = true;
	public final boolean REVERSE = false;
	
	private Victor leftLauncherMotorController;
	private Victor rightLauncherMotorController;
	
	private Talon leftTiltMotorController;
	private Talon rightTiltMotorController;
	
	//TODO: create electric solenoid thingy
	//TODO: some sort of sensor for detecting if the ball is in the shooter
	
	private static double launcherTilt;
	
	public void init(){
		launcherTilt = 0;
		leftLauncherMotorController = new Victor(RobotMap.SHOOTER_LEFT_MOTOR_CONTROLLER);
		rightLauncherMotorController = new Victor(RobotMap.SHOOTER_RIGHT_MOTOR_CONTROLLER);
		
		leftTiltMotorController = new Talon(RobotMap.SHOOTER_TILT_LEFT_MOTOR_CONTROLLER);
		rightTiltMotorController = new Talon(RobotMap.SHOOTER_TILT_RIGHT_MOTOR_CONTROLLER);
		
		//TODO: initialize solenoid thingy
	}
	
	public static double getTilt(){
		return launcherTilt;
	}
	
	public static void setTilt(double angle){
		launcherTilt = angle;
	}
	
	//if direction is set to false, it will run in reverse
	public void runShooterMotor(double speed, boolean direction){
		//adjust speed if needed
		if(!direction){
			//halve the speed and reverse the direction
			speed = -(speed/2);
		}
		
		leftLauncherMotorController.set(speed);
		rightLauncherMotorController.set(speed);
	}
	
	public void stopShooterMotors(){
		leftLauncherMotorController.set(0.0);
		rightLauncherMotorController.set(0.0);
	}
	
	public void runTiltMotors(double speed, boolean direction){
		if(!direction){
			//no need to halve the speed here
			speed = -speed;
		}
		
		leftTiltMotorController.set(speed);
		rightTiltMotorController.set(speed);
	}
	
	public void stopTiltMotors(){
		leftTiltMotorController.set(0.0);
		rightTiltMotorController.set(0.0);
	}
	
	public boolean ballIsInShooter(){
		//TODO: look at sensor to see if the ball is in the shooter
		return false;
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

