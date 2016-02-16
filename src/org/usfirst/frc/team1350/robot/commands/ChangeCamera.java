package org.usfirst.frc.team1350.robot.commands;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChangeCamera extends Command {
	
	private boolean isSwitched;
	private int camera;

    public ChangeCamera(int camera) {
    	this.camera = camera;
    	requires(Robot.raspi);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isSwitched = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	isSwitched = Robot.raspi.switchToCamera(camera);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isSwitched;
    }

    // Called once after isFinished returns true
    protected void end() {
    	isSwitched = false;
//    	Robot.raspi.turnOffCameras();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
