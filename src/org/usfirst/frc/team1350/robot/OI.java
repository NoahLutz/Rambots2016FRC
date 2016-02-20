package org.usfirst.frc.team1350.robot;

import org.usfirst.frc.team1350.robot.commands.ForwardShooterMotors;
import org.usfirst.frc.team1350.robot.commands.ReverseShooterMotors;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//Singleton
	private static OI instance;
	public static OI getInstance(){
		if (instance==null){
			instance = new OI();
		}
		return instance;
	}
	
	private OI(){
		Log.info("Initializing OI");
	}
	
	public Joystick leftStick;
	public Joystick rightStick;
	
	public JoystickButton motorForward;
	public JoystickButton motorReverse;
	public JoystickButton cancel;
	
	public AnalogInput tiltActuatorFeedback;
	public AnalogInput ballActuatorFeedback;
	
	public DigitalInput ballSwitch;
	
	//Initialize inputs
	public void init(){
		leftStick = new Joystick(RobotMap.JOYSTICK_LEFT);
		rightStick = new Joystick(RobotMap.JOYSTICK_RIGHT);
		
		motorForward = new JoystickButton(rightStick, RobotMap.CONT_FIRE_BUTTON);
		motorReverse = new JoystickButton(rightStick, RobotMap.CONT_REV_BUTTON);
		cancel = new JoystickButton(leftStick, RobotMap.CONT_CANCEL);
		
		tiltActuatorFeedback = new AnalogInput(RobotMap.SHOOTER_TILT_FEEDBACK);
		ballActuatorFeedback = new AnalogInput(RobotMap.SHOOTER_BALL_FEEDBACK);
		
		ballSwitch = new DigitalInput(RobotMap.SHOOTER_BALL_SWITCH);
		
//		motorForward.whenPressed(new ForwardShooterMotors());
//		motorReverse.whenPressed(new ReverseShooterMotors());
		
		motorForward.whenPressed(new ForwardShooterMotors());
	}
	
	public double getTiltFeedbackVoltage(){
		return tiltActuatorFeedback.getVoltage();
	}
	
	public double getBallFeedbackVoltage(){
		return ballActuatorFeedback.getVoltage();
	}
	
	public boolean ballIsInShooter(){
		return ballSwitch.get();
	}
}

