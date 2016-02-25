package org.usfirst.frc.team1350.robot.commands.shooter.autoaim;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.commands.shooter.AdjustShooter;
import org.usfirst.frc.team1350.robot.commands.shooter.ShooterHome;
import org.usfirst.frc.team1350.robot.subsystems.RangeFinder;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class AutoAimShoot extends CommandGroup {
	
	private Shooter shooter;
	private RangeFinder rangeFinder;
	
	private final static double velocityInMMPerSecond = 12000;
	private final static double heightOfGoalInMM = 2286;
	
	private static double adjustTiltSpeed = .125d;
	
	private double calculatedAngle;
	
	public void AutoAimShoot() {
		shooter = Shooter.getInstance();
		rangeFinder = RangeFinder.getInstance();
		
		double currentDistance = rangeFinder.getRange();
		calculatedAngle = AutoAimCalculations.calculateAngle(currentDistance, velocityInMMPerSecond, heightOfGoalInMM);
		Log.info("AutoAimShoot calculated: " + calculatedAngle);
		
		// TODO, should not need to home shooter
		addSequential(new ShooterHome(adjustTiltSpeed));
		Log.info("Moving To: " + calculatedAngle);
		addSequential(new AdjustShooter(calculatedAngle, adjustTiltSpeed));
		Log.info("Got to finish angle: " + calculatedAngle);
		// TODO add shoot code back
		//addSequential(new ShootBall(shootSpeed, rampDownDelay, shooterTimeout));

	}
	

}
