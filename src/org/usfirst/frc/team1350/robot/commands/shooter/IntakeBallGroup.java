package org.usfirst.frc.team1350.robot.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeBallGroup extends CommandGroup {
    
    public IntakeBallGroup() {    
    	float intakeSpeed = 0.5f;
    	addSequential(new ShooterHome());
    	addSequential(new IntakeBall(intakeSpeed));
    }
}
