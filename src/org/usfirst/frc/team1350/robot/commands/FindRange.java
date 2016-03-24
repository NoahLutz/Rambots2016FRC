package org.usfirst.frc.team1350.robot.commands;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.RangeFinder;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FindRange extends Command {

	
	private RangeFinder rangefinder;
    public FindRange() {
    	rangefinder = RangeFinder.getInstance();
    	requires(rangefinder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//SmartDashboard.putNumber("Range", rangefinder.getRange());
    	//SmartDashboard.putNumber("Raw Voltage", rangefinder.getRaw());
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
}
