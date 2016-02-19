package org.usfirst.frc.team1350.robot.commands;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ForwardShooterMotors extends RunShooterMotors {

	@Override
	protected void initialize() {
		Log.info("Initalizing ForwardShooterMotors");
	}

	@Override
	protected void execute() {
		shooter.runShooterMotor(1, Shooter.FORWARD);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return !(shooter.ballIsInShooter());
	}

    
}
