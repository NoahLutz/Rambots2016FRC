package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeBallGroup extends CommandGroup {
    
    public IntakeBallGroup() {    
    	float intakeSpeed = 0.5f;
    	Log.info("Entering IntakeBallGroup");
    	addSequential(new ShooterHome(0.25d));
    	addSequential(new IntakeBall(intakeSpeed));
    }
}
