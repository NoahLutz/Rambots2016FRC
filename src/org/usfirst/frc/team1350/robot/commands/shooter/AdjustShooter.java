package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;
import org.usfirst.frc.team1350.robot.utils.Utils;

import edu.wpi.first.wpilibj.command.Command;

public class AdjustShooter extends Command {
	
	private Shooter shooter;
	private double requestedAngle;
	private int calculatedEncoderSteps;
	private double rotationSpeed;
	
	private boolean currentDirection = false;
	
	public AdjustShooter(double angle, double rotationSpeed) {
		shooter = shooter.getInstance();
		
		requestedAngle = angle;
		calculatedEncoderSteps = (int) Shooter.convertAngleToEncoderSteps(requestedAngle);
		
		this.rotationSpeed = rotationSpeed;
		
		requires(shooter);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Log.info("inside execute AdjustShooter");
		// TODO Auto-generated method stub
		int currentTilt = shooter.getCurrentShooterTilt();
		Log.info("CurrentTiltEncoder, " + currentTilt);
		Log.info("RequestedEncoder, " + calculatedEncoderSteps);
		boolean direction = Shooter.TILT_FORWARD;
		
		if(currentTilt > calculatedEncoderSteps) {
			direction = Shooter.TILT_REVERSE;
		} 
		
		Log.info("Direction: " + direction);
		
		currentDirection = direction;
		shooter.runTiltMotors(rotationSpeed, direction);
	}

	@Override
	protected boolean isFinished() {
		int currentEncoder = shooter.getCurrentShooterTilt();
		// TODO replace precision with variable, 
		// TODO even better replace with PID/Proptional motor movement code 
		boolean isAtAngle = Utils.rangeCheck(calculatedEncoderSteps, currentEncoder, 5);
		
		// Checks the current direction and if limit in that direction is hit, estop
		if(currentDirection == Shooter.TILT_FORWARD && shooter.bottomLimitIsHit()) {
			Log.info("Tried to move shooter forward, but at limit");
			return true;
		} else if(currentDirection == Shooter.TILT_REVERSE && shooter.topLimitIsHit()) {
			Log.info("Tried to move shooter backward, but at limit");
			return true;
		}
		
		return isAtAngle;
	}

	@Override
	protected void end() {
		shooter.stopTiltMotors();
		// TODO Auto-generated method stub
		Log.info("Leaving AdjustShooter");
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
