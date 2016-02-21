package org.usfirst.frc.team1350.robot.commands;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.OI;
import org.usfirst.frc.team1350.robot.subsystems.Drivetrain;

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

	//define variables
	private boolean squaredInputs;
	private final static double speed = 1;
	
    public TeleOpTankDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//Send name for debugging
    	super("TeleOpTankDrive");
    	
    	//define required subsystems
    	requires(Drivetrain.getInstance());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Log.info("Initializing TeleOpTankDrive");
    	
    	squaredInputs = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Drivetrain.getInstance().tankDrive(getLeftStick(), getRightStick(), squaredInputs);
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
    
    private static double getLeftStick(){
    	return (OI.getInstance().leftStick.getY()) * speed;
    }
    
    private static double getRightStick(){
    	return (OI.getInstance().rightStick.getY()) * speed;
    }
}
