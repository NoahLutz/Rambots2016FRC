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
import org.usfirst.frc.team1350.robot.commands.ChangeCamera;

import edu.wpi.first.wpilibj.buttons.Button;
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
//		init();
	}
	
	public Joystick leftStick;
	public Joystick rightStick;
	public Joystick controller;
	
	public DigitalOutput camera1;
	public DigitalOutput camera2;
	
	public Button cameraSwitchButton1;
	public Button cameraSwitchButton2;
	public Button cameraSwitchButton3;
	public Button cameraSwitchButton4;
	
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
//		controller = new Joystick(RobotMap.CONTROLLER);
		
		camera1 = new DigitalOutput(RobotMap.RPI_CAMERA_SET1);
		camera2 = new DigitalOutput(RobotMap.RPI_CAMERA_SET2);
		
		cameraSwitchButton1 = new JoystickButton(rightStick, RobotMap.CONT_CAM1);
		cameraSwitchButton2 = new JoystickButton(rightStick, RobotMap.CONT_CAM2);
		
		cameraSwitchButton1.whenPressed(new ChangeCamera(RobotMap.RPI_CAMERA_SET1));
		cameraSwitchButton2.whenPressed(new ChangeCamera(RobotMap.RPI_CAMERA_SET2));
	}
}

