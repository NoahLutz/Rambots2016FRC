package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;
import org.usfirst.frc.team1350.robot.utils.Utils;

import edu.wpi.first.wpilibj.command.Command;

public class AdjustShooter extends Command {
	
	private Shooter shooter;
	private float requestedAngle;
	private int calculatedEncoderSteps;
	private double rotationSpeed;
	
	public AdjustShooter(float angle, double rotationSpeed) {
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
		
		boolean direction = Shooter.FORWARD;
		
		if(currentTilt < calculatedEncoderSteps) {
			direction = Shooter.REVERSE;
		} 
		
		shooter.runTiltMotors(rotationSpeed, direction);
	}

	@Override
	protected boolean isFinished() {
		int currentEncoder = shooter.getCurrentShooterTilt();
		// TODO replace precision with variable, 
		// TODO even better replace with PID/Proptional motor movement code 
		boolean isAtAngle = Utils.rangeCheck(calculatedEncoderSteps, currentEncoder, 5);
		
		// TODO only check the limit switch in the direction we are going, use the encoder values to determin that
		
		return isAtAngle || shooter.isAnyLimitHit();
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
