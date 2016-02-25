package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterHome extends Command{

	private Shooter shooter;
	private double speed = 0.25d;
	
	public ShooterHome(double speed){
		this.speed = speed;
		shooter = Shooter.getInstance();
		Log.info("Creating new ShooterHome()");
		
		requires(shooter);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		// TODO change to encoder location
		//Log.info("inside execute in ShooterHome");
		shooter.runTiltMotors(speed, Shooter.TILT_REVERSE);
	}

	@Override
	protected boolean isFinished() {
		Log.info("LimitHit, " + shooter.topLimitIsHit());
		return shooter.topLimitIsHit();
	}

	@Override
	protected void end() {
		Log.info("Leaving ShooterHome()");
		shooter.stopTiltMotors();
		shooter.resetEncoder();
	}

	@Override
	protected void interrupted() {
	}

}
