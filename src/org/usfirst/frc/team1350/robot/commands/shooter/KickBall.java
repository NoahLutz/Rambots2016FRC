package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class KickBall extends Command {

	private Shooter shooter;
	private double rampUpDelay;
	private double timeout = 2;
	
	public KickBall(double rampUpDelay) {
		shooter = Shooter.getInstance();
		this.rampUpDelay = rampUpDelay;
		Log.info("NewKickBall");
		requires(shooter);
	}
	
	@Override
	protected void initialize() {
		Log.info("InitKickBall: RampUp: " + rampUpDelay);
		Timer.delay(rampUpDelay);
		setTimeout(timeout+rampUpDelay);
	}

	@Override
	protected void execute() {
		shooter.kickBall();
//		Log.info("Running kickball");
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		shooter.stopKickingBall();
	}

	@Override
	protected void interrupted() {
	}
	
	
	

}
