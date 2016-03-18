package org.usfirst.frc.team1350.robot.commands.shooter;

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
		
		requires(shooter);
	}
	
	@Override
	protected void initialize() {
		Timer.delay(rampUpDelay);
		setTimeout(timeout);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		shooter.kickBall();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		shooter.stopKickingBall();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
