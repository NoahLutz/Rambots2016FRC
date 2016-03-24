package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;
import org.usfirst.frc.team1350.robot.utils.Utils;

import edu.wpi.first.wpilibj.command.Command;

public class PIDAngleAdjustShooter extends Command {

	private Shooter shooter;
	private double requestedAngle;
	private int calculatedEncoderSteps;
	private double rotationSpeed;
	private boolean currentDirection;
	private double timeout = 3;
	
	public PIDAngleAdjustShooter(double angle, double rotationSpeed) {
		shooter = Shooter.getInstance();
		this.setTimeout(timeout);
		requestedAngle = angle;
		
		this.rotationSpeed = rotationSpeed;
		requires(shooter);
	}
	
	@Override
	protected void initialize() {
		shooter.enable();
		int currentTilt = shooter.getCurrentShooterTilt();
		calculatedEncoderSteps = (int) Shooter.convertAngleToEncoderSteps(requestedAngle);
		// Invert the angle to go from the home position not the front end, subtract the max encoder steps
		calculatedEncoderSteps = Math.abs(calculatedEncoderSteps - 3500);

		Log.info("CurrentTiltEncoder, " + currentTilt);
		Log.info("RequestedEncoder, " + calculatedEncoderSteps);
		boolean direction = Shooter.TILT_FORWARD;
		
		if(currentTilt > calculatedEncoderSteps) {
			direction = Shooter.TILT_REVERSE;
		} 
		
		Log.info("Direction: " + direction);
		
		currentDirection = direction;
		
		shooter.setSetpoint(calculatedEncoderSteps);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// Checks the current direction and if limit in that direction is hit, estop
		if(currentDirection == Shooter.TILT_FORWARD && shooter.bottomLimitIsHit()) {
			Log.info("Tried to move shooter forward, but at limit");
			return true;
		} else if(currentDirection == Shooter.TILT_REVERSE && shooter.topLimitIsHit()) {
			Log.info("Tried to move shooter backward, but at limit");
			return true;
		}
		
		int currentAngle = shooter.getCurrentShooterTilt();
		if(Utils.rangeCheck(calculatedEncoderSteps, currentAngle, 200)) {
			Log.info("Shooter At Setpoint, exiting");
			return true;
		}	
		
		if(this.isTimedOut()) {
			return true;
		}
		
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		//shooter.disable();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
	public void setAngle(double angle) {
		requestedAngle = angle;
		calculatedEncoderSteps = (int) Shooter.convertAngleToEncoderSteps(requestedAngle);
	}

}
