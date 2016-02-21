package org.usfirst.frc.team1350.robot.commands.shooter;

public class RetractBallActuator extends BallActuator {
	
	private static int launchPosition = 1;
	private static float timeout = 2;
	
	public RetractBallActuator() {
		super(launchPosition, timeout, 0);
	}

}
