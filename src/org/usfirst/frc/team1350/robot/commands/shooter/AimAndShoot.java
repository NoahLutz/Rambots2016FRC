package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AimAndShoot extends CommandGroup {
	
	// Ramp up time in seconds
	private static double rampUpDelay = 2;
	private static double rampDownDelay = 2; // after ball exits run for this # of seconds

	// -1.0 to 1.0
	private static double shootSpeed = 1.0;	
	private static double shooterTimeout = 10;

	public AimAndShoot() {
//		addSequential(new SetShooterToHigh());
		//addSequential(new RampAndShootBallGroup(shootSpeed, rampUpDelay, rampDownDelay));
		//addSequential(new RetractBallActuator());
		
		addSequential(new ShooterHome());
		// TODO remove once we set home finding code else where
		Shooter.getInstance().findHome();
		addSequential(new AdjustShooter(10, 0.25d));
		//addSequential(new ShootBall(shootSpeed, rampDownDelay, shooterTimeout));
	}
	

}
