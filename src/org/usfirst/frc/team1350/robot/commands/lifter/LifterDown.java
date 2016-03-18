package org.usfirst.frc.team1350.robot.commands.lifter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.Command;

public class LifterDown extends Command{

	private Lifter lifter;
	private final double timeout = 3d;
	private final double speed = .3;
	
	public LifterDown(){
		lifter = Lifter.getInstance();
		requires(lifter);
	}
	
	@Override
	protected void initialize() {
		setTimeout(timeout);
	}

	@Override
	protected void execute() {
//		Log.info("Reverse");
		lifter.runMotor(speed, Lifter.REVERSE);
	}

	@Override
	protected boolean isFinished() {
		return lifter.bottomLimitIsHit() || isTimedOut();
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
