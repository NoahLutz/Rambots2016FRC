package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeBallGroup extends CommandGroup {
    
    public IntakeBallGroup() {
    	float intakeSpeed = 0.5f;

    	//addSequential(new ShooterHome());
    	addSequential(new PIDEncoderAdjustShooter(4500, 3));
    	addSequential(new IntakeBall(intakeSpeed));
    	addSequential(new ShooterMidpoint());
    }
}
