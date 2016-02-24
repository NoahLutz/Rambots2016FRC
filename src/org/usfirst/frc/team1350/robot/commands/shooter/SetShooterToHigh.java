package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class SetShooterToHigh extends Command{

	private Shooter shooter;
	private final double SPEED = .25d;
	
	public SetShooterToHigh(){
		shooter = Shooter.getInstance();
		requires(shooter);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		shooter.runTiltMotors(SPEED, Shooter.FORWARD);
	}

	@Override
	protected boolean isFinished() {
		// TODO replace with encoder 
		return shooter.topLimitIsHit() ; // || atCorrectAngle()
	}

	@Override
	protected void end() {
		shooter.stopTiltMotors();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
