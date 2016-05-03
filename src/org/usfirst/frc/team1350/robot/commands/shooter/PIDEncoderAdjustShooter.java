package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;
import org.usfirst.frc.team1350.robot.utils.Utils;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class PIDEncoderAdjustShooter extends Command {

	public Shooter shooter;
	public int encoderSteps;
	public PIDEncoderAdjustShooter(int encoderSteps, double timeout) {
		shooter = Shooter.getInstance();
		this.setTimeout(timeout);
		
		this.encoderSteps = encoderSteps;
		
		requires(shooter);
	}
	
	@Override
	protected void initialize() {
//		Timer.delay(5);
		shooter.enable();
		Log.info("Init, Encoder Steps: " + encoderSteps);
		// TODO Auto-generated method stub
		shooter.setSetpoint(encoderSteps);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		int currentAngle = shooter.getCurrentShooterTilt();
		if(Utils.rangeCheck(encoderSteps, shooter.getCurrentShooterTilt(), 100)) {
			Log.info("Shooter At Setpoint, exiting");
			return true;
		}	
		
		if(this.isTimedOut()) {
			return true;
		}
		
		if(shooter.bottomLimitIsHit() || shooter.topLimitIsHit()) {
			Log.info("Limit Hit");
			return true;
		}
		
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
//		shooter.disable();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
//		shooter.disable();
	}
	
	public void setEncoderSteps(int encoderSteps) {
		this.encoderSteps = encoderSteps;
	}
	
	

}
