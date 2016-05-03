package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RampAndShootBallGroup extends CommandGroup {
	
	
	
	public RampAndShootBallGroup(double shootSpeed, double rampDownDelay, double timeout) {
//		addParallel(new ShootBall(shootSpeed, rampDownDelay, timeout));
//		addParallel(new KickBall(rampUpDelay));
		
		addSequential(new PIDEncoderAdjustShooter(Shooter.ANGLE_MIDPOINT_ENCODER,.5));
		addSequential(new ShootBall(shootSpeed, rampDownDelay, timeout, .5));

//		addParallel(new KickBall(1));
	}

}
