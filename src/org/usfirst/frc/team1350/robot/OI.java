package org.usfirst.frc.team1350.robot;

import org.usfirst.frc.team1350.robot.commands.shooter.AimAndShoot;
import org.usfirst.frc.team1350.robot.commands.shooter.IntakeBall;
import org.usfirst.frc.team1350.robot.commands.shooter.IntakeBallGroup;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;
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
	
	public JoystickButton intakeBallButton;
	public JoystickButton shootBallButton;
	
	public AnalogInput tiltActuatorFeedback;
	public AnalogInput ballActuatorFeedback;
		
	public DigitalInput ballSwitch;
	
	//Initialize inputs
	public void init(){
		leftStick = new Joystick(RobotMap.JOYSTICK_LEFT);
		rightStick = new Joystick(RobotMap.JOYSTICK_RIGHT);
		
		intakeBallButton = new JoystickButton(leftStick, RobotMap.CONT_FIRE_BUTTON);
		shootBallButton = new JoystickButton(rightStick, RobotMap.CONT_FIRE_BUTTON);
				
		intakeBallButton.whenPressed(new IntakeBallGroup());
		shootBallButton.whenPressed(new AimAndShoot());
	}
}

