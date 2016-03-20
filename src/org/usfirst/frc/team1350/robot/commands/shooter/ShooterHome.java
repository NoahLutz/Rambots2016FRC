package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ShooterHome extends Command{

	private Shooter shooter;
	private double speed=.4;
	
	public ShooterHome(){
		shooter = Shooter.getInstance();
		requires(shooter);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		shooter.enable();

		Log.info("ENCODER: " + shooter.getCurrentShooterTilt());
//		shooter.runTiltMotors(speed, Shooter.TILT_REVERSE);
	}

	@Override
	protected boolean isFinished() {
		if(shooter.topLimitIsHit()){
			Log.info("Shooter is home");
		}
		return shooter.topLimitIsHit();
	}

	@Override
	protected void end() {
//		shooter.stopTiltMotors();
		shooter.disable();
		shooter.resetEncoder();
	}

	@Override
	protected void interrupted() {
//		shooter.stopTiltMotors();
		shooter.disable();
	}
}
