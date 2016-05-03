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
	private double timeout = 6;
	
	private static final float REVERSE_SHOOTER_TIMEOUT = 10;
	
	public IntakeBall(float intakeSpeed) {
		Log.info("New IntakeBalls");
		setTimeout(REVERSE_SHOOTER_TIMEOUT);
		
		speed = intakeSpeed;
		shooter = Shooter.getInstance();
		
		requires(shooter);
	}

	@Override
	protected void initialize() {
		Log.info("Initalizing ReverseShooterMotors");
		setTimeout(timeout);
	}

	@Override
	protected void execute() {
		Log.info("Execute run shooter motor");
		shooter.runShooterMotor(speed, Shooter.REVERSE);
	}

	@Override
	protected boolean isFinished() {
		// TODO invert the method name
		if(shooter.ballIsInShooter()){
			Log.info("in IsFinished IntakeBall");
		}
		return (shooter.ballIsInShooter()) || isTimedOut();
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
