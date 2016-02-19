package org.usfirst.frc.team1350.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeBall extends CommandGroup {
    
    public  IntakeBall() {
    	addSequential(new ShooterHome());
    	addSequential(new ReverseShooterMotors());
    }
}
