package org.usfirst.frc.team1350.robot.commands.lifter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.Command;

public class LifterUp extends Command{

	
	private Lifter lifter;
	private final double timeout = 3d;
	
	public LifterUp(){
		lifter = Lifter.getInstance();
		requires(lifter);
	}
	
	@Override
	protected void initialize() {
		setTimeout(timeout);
	}

	@Override
	protected void execute() {
//		Log.info("Forward");
		lifter.runMotor(1, Lifter.FORWARD);
	}

	@Override
	protected boolean isFinished() {
		return lifter.topLimitIsHit() || isTimedOut();
	}

	@Override
	protected void end() {
		lifter.stopMotor();
	}

	@Override
	protected void interrupted() {
		lifter.stopMotor();
	}

}
