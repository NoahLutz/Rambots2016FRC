package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.subsystems.Shooter;

public class ShooterMidpoint extends PIDEncoderAdjustShooter{
	
	static double timeout = .7;
	public static int target = Shooter.ANGLE_MIDPOINT_ENCODER;
	
	public ShooterMidpoint(){
		super(0,timeout);
		
		int currentSetpoint = (int) Shooter.getInstance().getSetpoint();
		if(currentSetpoint==target){
			return;
		}else if (currentSetpoint < target){
			int encoderSteps = target - currentSetpoint;
			this.setEncoderSteps(encoderSteps);
		}else if(currentSetpoint > target){
			int encoderSteps = currentSetpoint - target;
			this.setEncoderSteps(encoderSteps);
		}
	}

}
