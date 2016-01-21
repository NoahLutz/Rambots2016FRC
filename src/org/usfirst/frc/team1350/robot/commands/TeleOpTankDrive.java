package org.usfirst.frc.team1350.robot.commands;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleOpTankDrive extends Command {
	
	//singleton
	private static TeleOpTankDrive instance;
	public static TeleOpTankDrive getInstance(){
		if (instance==null){
			instance = new TeleOpTankDrive();
		}
		return instance;
	}

	private boolean squaredInputs;
	
    public TeleOpTankDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super("TeleOpTankDrive");
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Log.info("Initializing TeleOpTankDrive");
    	squaredInputs = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.tankDrive(getLeftStick(), getRightStick(), squaredInputs);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private static Joystick getLeftStick(){
    	//TODO:get left stick 
    	return Robot.oi.leftStick;
    }
    
    private static Joystick getRightStick(){
    	//TODO:get right stick
    	return Robot.oi.rightStick;
    }
}
