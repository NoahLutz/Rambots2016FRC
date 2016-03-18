package org.usfirst.frc.team1350.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RampAndShootBallGroup extends CommandGroup {
	
	
	
	public RampAndShootBallGroup(double shootSpeed, double rampUpDelay, double rampDownDelay, double timeout) {
		addParallel(new KickBall(rampUpDelay));
//		addParallel(new ShootBall(shootSpeed, rampDownDelay, timeout));
	}

}
