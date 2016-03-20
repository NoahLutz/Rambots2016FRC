package org.usfirst.frc.team1350.robot.commands.auto;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.Robot;
import org.usfirst.frc.team1350.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command{

	//TODO: test and adjust
	private final float DRIVE_TIME = 4;
	private final float SPEED = 1;
	
	private Drivetrain drivetrain;
	
	public AutoDrive(){
		drivetrain = Drivetrain.getInstance();
		requires(drivetrain);
	}
	
	@Override
	protected void initialize() {
		Log.info("Running AutoDrive");
		setTimeout(DRIVE_TIME);
	}

	@Override
	protected void execute() {
		drivetrain.autoDrive(SPEED, 0);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
