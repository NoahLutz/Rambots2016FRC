package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ShootBall extends Command {
	
	private Shooter shooter;
	private double speed;
	private double stopMotorDelay;
	
	// Speed is -1.0 to 1.0, delay is time in seconds
	public ShootBall(double speed, double stopMotorDelay, double timeout) {
		setTimeout(timeout);
		shooter = Shooter.getInstance();
		this.stopMotorDelay = stopMotorDelay;
		this.speed = speed;
		
		requires(shooter);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		shooter.runShooterMotor(speed, Shooter.FORWARD);
	}

	@Override
	protected boolean isFinished() {
		// When ball switch is released end command
		if(!shooter.ballIsInShooter()) {
			return true;
		}
		return false;
	}

	@Override
	protected void end() {
		Timer.delay(stopMotorDelay);
		shooter.stopShooterMotors();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
