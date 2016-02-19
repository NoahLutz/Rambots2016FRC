package org.usfirst.frc.team1350.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FireBall extends CommandGroup {
    
    public  FireBall() {
    	addSequential(new FindOptimalAngle());
    	addSequential(new ForwardShooterMotors());
    }
}
