package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;
import org.usfirst.frc.team1350.robot.utils.Utils;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.command.Command;

public class MoveActuatorAnalog extends Command {
	
	private AnalogOutput actuator;
	private AnalogInput actuatorFeedback;

	private int requestedPosition;
	private float positionVoltage;
	private float precision = 0.25f;
	private float dutyCycle;
		
    public MoveActuatorAnalog(AnalogOutput acutator, AnalogInput acutatorFeedback, int requestedPosition, float timeout) {	
    	setTimeout(timeout);
    	Log.info("New MoveActuator");
    	this.requestedPosition = requestedPosition;
    	this.actuatorFeedback = acutatorFeedback;
    	
    	// calculate positionVoltage by range mapping 0-255 to 0-3.3
    	positionVoltage = Utils.remap(requestedPosition, 0f, 255f, 0, 3.3f);
    	dutyCycle = Utils.remap(requestedPosition, 0, 255, 0, 5);
    	
    	this.actuator = acutator;
    	// TODO maybe remove
    	requires(Shooter.getInstance());
    }

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	
	}

	@Override
	protected void execute() {
		Log.info("Analog MoveActuator execute: " + actuator.getVoltage());
		actuator.setVoltage(5);
		//Log.info("Position: " + actuator.get);
    	///actuator.actuator.setRaw(requestedPosition);
//		actuator.setPWMRate(1);
//		actuator.set(true);
//		actuator.updateDutyCycle(1);
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
		actuator.setVoltage(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
