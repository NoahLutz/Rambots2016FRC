package org.usfirst.frc.team1350.robot.subsystems;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.RobotMap;
import org.usfirst.frc.team1350.robot.commands.TeleOpTankDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	
	//Singleton
	private static Drivetrain instance;
	public static Drivetrain getInstance(){
		if (instance==null){
			instance = new Drivetrain();
		}
		return instance;
	}
    
    
	private Talon leftMotorController;
	private Talon rightMotorController;
	private RobotDrive robotDrive;
	private TeleOpTankDrive tankDrive;
	
	public Drivetrain(){
		Log.info("Initializing Drivetrain subsystem");
	}

	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void init(){
		tankDrive =TeleOpTankDrive.getInstance();
		leftMotorController = new Talon(RobotMap.DRIVE_TRAIN_LEFT_MOTOR_CONTROLLER);
		rightMotorController = new Talon(RobotMap.DRIVE_TRAIN_RIGHT_MOTOR_CONTROLLER);
		robotDrive = new RobotDrive(leftMotorController, rightMotorController);
	}
	
	public void tankDrive(double left, double right, boolean squaredInputs){
		robotDrive.tankDrive(-left, -right, squaredInputs);
	}
	
	public void autoDrive(double speed, double curve){
		robotDrive.drive(speed, curve);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(tankDrive);
    }
}

