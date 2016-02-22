package org.usfirst.frc.team1350.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AimAndShoot extends CommandGroup {
	
	// Ramp up time in seconds
	private static double rampUpDelay = 2;
	private static double rampDownDelay = 2;

	// -1.0 to 1.0
	private static double shootSpeed = 1.0;
	
	public AimAndShoot() {
		//addSequential(new SetShooterToHigh());
		//addSequential(new RampAndShootBallGroup(shootSpeed, rampUpDelay, rampDownDelay));
		//addSequential(new RetractBallActuator());
		
		addSequential(new ShootBall(shootSpeed, 1d));
	
	}
	

}
