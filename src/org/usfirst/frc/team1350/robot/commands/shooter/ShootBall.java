package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ShootBall extends Command {
	
	private Shooter shooter;
	private double speed;
	private double stopMotorDelay;
	private double shootBallDelay;
	private double timeout;
	
	// Speed is -1.0 to 1.0, delay is time in seconds
	public ShootBall(double speed, double stopMotorDelay, double timeout, double shootBallDelay) {
		this.timeout = timeout;
		shooter = Shooter.getInstance();
		this.stopMotorDelay = stopMotorDelay;
		this.speed = speed;
		this.shootBallDelay = shootBallDelay;
		requires(shooter);
	}

	@Override
	protected void initialize() {
		setTimeout(timeout);
	}

	@Override
	protected void execute() {
//		Log.info("Shooting Ball");
		shooter.runShooterMotor(speed, Shooter.FORWARD);
		Timer.delay(shootBallDelay);
		shooter.kickBall();
	}

	@Override
	protected boolean isFinished() {
		// When ball switch is released end command
		if(!shooter.ballIsInShooter()) {
			Log.info("Finishing ShootBall");
			return true;
		}
		return false || isTimedOut();
	}

	@Override
	protected void end() {
		Timer.delay(stopMotorDelay);
		shooter.stopShooterMotors();
		shooter.stopKickingBall();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
