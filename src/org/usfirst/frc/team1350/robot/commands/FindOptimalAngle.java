package org.usfirst.frc.team1350.robot.commands;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FindOptimalAngle extends Command {

	private Shooter shooter;
	private boolean foundAngle;
	
    public FindOptimalAngle() {
    	shooter = Shooter.getInstance();
    	requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	foundAngle = false;
    	Log.info("Initalizing FindOptimalAngle");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//TODO: Create algorithm to find optimal angle
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return foundAngle;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
