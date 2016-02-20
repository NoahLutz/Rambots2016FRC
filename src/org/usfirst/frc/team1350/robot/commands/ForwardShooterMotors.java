package org.usfirst.frc.team1350.robot.commands;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.Robot;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ForwardShooterMotors extends AbstractShooterInstance {

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
		return !(shooter.ballIsInShooter());
	}

    
}
