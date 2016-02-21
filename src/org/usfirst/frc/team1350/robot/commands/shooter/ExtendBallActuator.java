package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.command.Command;

public class ExtendBallActuator extends BallActuator {
		
	private static int launchPosition = 255;
	private static float timeout = 2;
	
	public ExtendBallActuator(double delay) {
		super(launchPosition, timeout, delay);
	}

}
