package org.usfirst.frc.team1350.robot.commands.shooter.autoaim;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.commands.shooter.KickBall;
import org.usfirst.frc.team1350.robot.commands.shooter.ShootBall;
import org.usfirst.frc.team1350.robot.commands.shooter.ShooterMidpoint;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class FullAutoAim extends CommandGroup {

	private double rampUpDelay = 1;
	
	public FullAutoAim() {
		Log.info("FullAutoAim");
		addSequential(new AutoAimAngleAdjust());
//        addParallel(new ShootBall(1,1,6));
		Timer.delay(1);
		addSequential(new ShootBall(1,1,6, 1.5));
		addParallel(new KickBall(.5));

        addSequential(new ShooterMidpoint());
	}
}
