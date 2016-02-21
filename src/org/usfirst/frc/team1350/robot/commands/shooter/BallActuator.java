package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Timer;

public class BallActuator extends MoveActuator {
	
	private static PWM ballPWM = Shooter.getBallPWM();
	private static AnalogInput ballFeedback = Shooter.getBallFeedback();
	
	public BallActuator(int requestedPosition, float timeout, double delay) {
		super(ballPWM, ballFeedback, requestedPosition, timeout);
		
		Timer.delay(delay);
	}

}
