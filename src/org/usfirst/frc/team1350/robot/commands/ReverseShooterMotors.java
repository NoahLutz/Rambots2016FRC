package org.usfirst.frc.team1350.robot.commands;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReverseShooterMotors extends RunShooterMotors {

	@Override
	protected void initialize() {
		Log.info("Initalizing ReverseShooterMotors");
	}

	@Override
	protected void execute() {
		shooter.runShooterMotor(0.5, Shooter.REVERSE);
	}

	@Override
	protected boolean isFinished() {
		return !(shooter.ballIsInShooter());
	}

    
}
