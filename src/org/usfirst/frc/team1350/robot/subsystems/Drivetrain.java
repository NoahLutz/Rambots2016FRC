package org.usfirst.frc.team1350.robot.subsystems;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.RobotMap;
import org.usfirst.frc.team1350.robot.commands.TeleOpTankDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
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
    
	private VictorSP leftMotorController;
	private VictorSP rightMotorController;
	private RobotDrive robotDrive;
	private TeleOpTankDrive tankDrive;
	
	public Drivetrain(){
		Log.info("Creating Drivetrain subsystem");
//		init();
	}

	public void init(){
		tankDrive =TeleOpTankDrive.getInstance();
		leftMotorController = new VictorSP(RobotMap.DRIVE_TRAIN_LEFT_MOTOR_CONTROLLER);
		rightMotorController = new VictorSP(RobotMap.DRIVE_TRAIN_RIGHT_MOTOR_CONTROLLER);
		robotDrive = new RobotDrive(leftMotorController, rightMotorController);
	}
	
	public void tankDrive(double left, double right, boolean squaredInputs){
		robotDrive.tankDrive(-left, -right, false);
	}
	
	public void autoDrive(double speed, double curve){
		robotDrive.drive(speed, curve);
	}
	
	public void driveLeftMotor(double speed, double time){
		leftMotorController.set(speed);
		Timer.delay(time);
		leftMotorController.set(0);
	}
	
	public void driveRightMotor(double speed, double time){
		rightMotorController.set(speed);
		Timer.delay(time);
		rightMotorController.set(0);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(tankDrive);
    }
}

