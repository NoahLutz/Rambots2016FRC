package org.usfirst.frc.team1350.robot.commands.shooter.autoaim;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.commands.shooter.AdjustShooter;
import org.usfirst.frc.team1350.robot.commands.shooter.PIDAngleAdjustShooter;
import org.usfirst.frc.team1350.robot.commands.shooter.ShooterHome;
import org.usfirst.frc.team1350.robot.subsystems.RangeFinder;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class AutoAimAngleAdjust extends PIDAngleAdjustShooter {
	
	private Shooter shooter;
	private RangeFinder rangeFinder;
	
	private final static double velocityInMMPerSecond = 12000;
	private final static double heightOfGoalInMM = 2286;
	
	private static double adjustTiltSpeed = .25d;
	
	private double calculatedAngle;

	public AutoAimAngleAdjust() {
		// Setting angle to zero, calculating angle in init, then moving
		super(0, adjustTiltSpeed);
		shooter = Shooter.getInstance();
		rangeFinder = RangeFinder.getInstance();
	}
	
	@Override
	public void initialize() {
		double currentDistance = rangeFinder.getRange();
		calculatedAngle = AutoAimCalculations.calculateAngle(currentDistance, velocityInMMPerSecond, heightOfGoalInMM);
		calculatedAngle += 30;
		Log.info("AutoAimShoot calculated: " + calculatedAngle);
		
		// TODO add out of range angle default angle/move to highest
		
		// TODO, home shooter on init, VERY IMPORTANT
		Log.info("Moving To: " + calculatedAngle);	
		SmartDashboard.putNumber("CalculatedAngle", calculatedAngle);
		this.setAngle(calculatedAngle);
		super.initialize();
	}


}
