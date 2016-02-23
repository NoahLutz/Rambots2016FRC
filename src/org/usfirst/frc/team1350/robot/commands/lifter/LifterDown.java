package org.usfirst.frc.team1350.robot.commands.lifter;

import org.usfirst.frc.team1350.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.Command;

public class LifterDown extends Command{

	private Lifter lifter;
	
	public LifterDown(){
		lifter = Lifter.getInstance();
		requires(lifter);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		lifter.runMotor(Lifter.SPEED, Lifter.REVERSE);
	}

	@Override
	protected boolean isFinished() {
		return lifter.bottomLimitIsHit();
	}

	@Override
	protected void end() {
		lifter.stopMotor();
	}

	@Override
	protected void interrupted() {
	}

}
