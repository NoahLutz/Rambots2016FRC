package org.usfirst.frc.team1350.robot.commands;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FindAngle extends Command {
	
	private boolean inPosition;
	private final double GOAL_HEIGHT = 7;
	

    public FindAngle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	requires(Robot.rangeFinder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Log.info("Initializing FindAngle");
    	inPosition = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double distanceFromWall = Robot.rangeFinder.getRange();
    	double angle = Math.toDegrees(Math.atan2(GOAL_HEIGHT, distanceFromWall));
    	//TODO: move motors to angle
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return inPosition;
    }

    // Called once after isFinished returns true
    protected void end() {
    	inPosition = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
