package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;
import org.usfirst.frc.team1350.robot.utils.Utils;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.command.Command;

public class MoveActuator extends Command {
	
	private PWM actuator;
	private AnalogInput actuatorFeedback;

	private int requestedPosition;
	private float positionVoltage;
	private float precision = 0.25f;
		
    public MoveActuator(PWM acutatorPWM, AnalogInput acutatorFeedback, int requestedPosition, float timeout) {	
    	setTimeout(timeout);
    	Log.info("New MoveActuator");
    	this.requestedPosition = requestedPosition;
    	this.actuatorFeedback = acutatorFeedback;
    	
    	// calculate positionVoltage by range mapping 0-255 to 0-3.3
    	positionVoltage = Utils.remap(requestedPosition, 0f, 255f, 3.3f, 0);
    	
    	actuator = acutatorPWM;
    	// TODO maybe remove
    	requires(Shooter.getInstance());
    }

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	
	}

	@Override
	protected void execute() {
		Log.info("MoveActuator execute: " + requestedPosition);
		Log.info("PWM Channel: " + actuator.getChannel());
		Log.info("Position: " + actuator.getRaw());
    	actuator.setRaw(requestedPosition);
	}

	@Override
	protected boolean isFinished() {
		Log.info("MoveActuator isFinished, Current Voltage: " + actuatorFeedback.getVoltage());
		// TODO send positionVoltage here not requestedPosition
    	boolean isHome = isPositioned(positionVoltage);
    	Log.info("MoveActuator isFinished, isHome?: " + isHome);
    	return isHome;
	}
	
	protected boolean isPositioned(float requestedVoltage) {
		float currentPosition = (float) actuatorFeedback.getVoltage();
		Log.info("RequestedVoltage: " + positionVoltage);
		boolean inPosition = Utils.rangeCheck(positionVoltage, currentPosition, precision);
		
		return inPosition;
	}

	@Override
	protected void end() {
		// Stop actuator position
		actuator.setRaw(0);		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
