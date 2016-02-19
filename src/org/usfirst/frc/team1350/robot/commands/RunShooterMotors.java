package org.usfirst.frc.team1350.robot.commands;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.OI;
import org.usfirst.frc.team1350.robot.Robot;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class RunShooterMotors extends Command {

	protected Shooter shooter;
	
    public RunShooterMotors() {
    	shooter = Shooter.getInstance();
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected abstract void initialize();

    // Called repeatedly when this Command is scheduled to run
    protected abstract void execute();

    // Make this return true when this Command no longer needs to run execute()
    protected abstract boolean isFinished();

    	// Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.stopShooterMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
