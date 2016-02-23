package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterHome extends Command{

	private Shooter shooter;
	private final double SPEED = -0.25d;
	
	public ShooterHome(){
		shooter = Shooter.getInstance();
		requires(shooter);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		shooter.runTiltMotors(SPEED, Shooter.REVERSE);
	}

	@Override
	protected boolean isFinished() {
		return shooter.bottomLimitIsHit();
	}

	@Override
	protected void end() {
		shooter.stopTiltMotors();
		shooter.resetEncoder();
	}

	@Override
	protected void interrupted() {
	}

}
