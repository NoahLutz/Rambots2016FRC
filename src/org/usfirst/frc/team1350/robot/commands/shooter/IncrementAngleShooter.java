package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.subsystems.Shooter;

public class IncrementAngleShooter extends PIDEncoderAdjustShooter {

	private int encoderIncrement;
	private static double timeout = .7;
	
	public IncrementAngleShooter(int increment) {
		super(0, timeout);
		encoderIncrement = increment;
		int currentEncoderSteps = (int) Shooter.getInstance().getSetpoint();
//		int currentEncoderSteps = Shooter.getInstance().getCurrentShooterTilt();
		this.setEncoderSteps(currentEncoderSteps + increment);
	}

}
