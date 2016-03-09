package org.usfirst.frc.team1350.robot.commands.auto;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurn extends Command {

	private Drivetrain drivetrain;
	private final double SPEED = .75;
	private final double TIMEOUT = 2;
	
    public AutoTurn() {
    	drivetrain = Drivetrain.getInstance();
    	requires(drivetrain);
    }

    protected void initialize() {
    	Log.info("Running AutoTurn");
    	setTimeout(TIMEOUT);
    }

    protected void execute() {
    	//TODO: idk if this is gonna work. needs to be tested
    	drivetrain.driveLeftMotor(SPEED, TIMEOUT-.1);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
