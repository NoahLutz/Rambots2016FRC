package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeBall extends Command {

	private Shooter shooter;
	private static float speed;
	
	private static final float REVERSE_SHOOTER_TIMEOUT = 10;
	
	public IntakeBall(float intakeSpeed) {
		setTimeout(REVERSE_SHOOTER_TIMEOUT);
		
		speed = intakeSpeed;
		shooter = Shooter.getInstance();
	}

	@Override
	protected void initialize() {
		Log.info("Initalizing ReverseShooterMotors");
	}

	@Override
	protected void execute() {
		shooter.runShooterMotor(speed, Shooter.REVERSE);
	}

	@Override
	protected boolean isFinished() {
		return (shooter.ballIsInShooter());
	}

	@Override
	protected void end() {
		shooter.stopShooterMotors();		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

    
}
