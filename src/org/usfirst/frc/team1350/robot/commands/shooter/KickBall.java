package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class KickBall extends Command {

	private Shooter shooter;
	private double rampUpDelay;
	private double timeout = .5;
	
	public KickBall(double rampUpDelay) {
		shooter = Shooter.getInstance();
		this.rampUpDelay = rampUpDelay;
		
		requires(shooter);
	}
	
	@Override
	protected void initialize() {
		Timer.delay(rampUpDelay);
		setTimeout(timeout);
	}

	@Override
	protected void execute() {
		shooter.kickBall();
		Log.info("Running kickball");
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
		shooter.stopKickingBall();
	}
	
	
	

}
