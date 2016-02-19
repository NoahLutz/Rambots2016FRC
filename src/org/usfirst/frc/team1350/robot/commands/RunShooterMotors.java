package org.usfirst.frc.team1350.robot.commands;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeBall extends Command {

    public IntakeBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Log.info("Initalizing IntakeBall");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//TODO: set tilt to bottom
    	Robot.shooter.runShooterMotor(1, Robot.shooter.REVERSE);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.shooter.ballIsInShooter();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.stopShooterMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
