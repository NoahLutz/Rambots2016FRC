package org.usfirst.frc.team1350.robot.commands;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.OI;
import org.usfirst.frc.team1350.robot.Robot;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public abstract class AbstractShooterInstance extends Command {

	protected Shooter shooter;
	
    public AbstractShooterInstance() {
    	shooter = Shooter.getInstance();
    	requires(shooter);
    }

    protected void end() {
    	Robot.shooter.stopShooterMotors();
    }

    protected void interrupted() {
    }
    
    protected abstract void initialize();
    protected abstract void execute();
    protected abstract boolean isFinished();
}
