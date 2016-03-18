package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class SetShooterToHigh extends Command{

	private Shooter shooter;
	private final double SPEED = .25d;
	
	public SetShooterToHigh(){
		shooter = Shooter.getInstance();
		requires(shooter);
	}
	
	@Override
	protected void initialize() {
		Log.info("SetShootertoHigh");
	}

	@Override
	protected void execute() {
		shooter.runTiltMotors(SPEED, Shooter.TILT_FORWARD);
	}

	@Override
	protected boolean isFinished() {
		return shooter.bottomLimitIsHit();
	}

	@Override
	protected void end() {
		shooter.stopTiltMotors();
	}

	@Override
	protected void interrupted() {
		shooter.stopTiltMotors();
	}

}
