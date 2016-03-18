package org.usfirst.frc.team1350.robot;

import org.usfirst.frc.team1350.robot.commands.shooter.AimAndShoot;
import org.usfirst.frc.team1350.robot.commands.shooter.IntakeBall;
import org.usfirst.frc.team1350.robot.commands.shooter.IntakeBallGroup;
import org.usfirst.frc.team1350.robot.commands.shooter.SetShooterToHigh;
import org.usfirst.frc.team1350.robot.commands.shooter.ShooterHome;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;
import org.usfirst.frc.team1350.robot.commands.ChangeCamera;
import org.usfirst.frc.team1350.robot.commands.lifter.LifterDown;
import org.usfirst.frc.team1350.robot.commands.lifter.LifterUp;

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
	
	public JoystickButton lifterUp;
	public JoystickButton lifterDown;
	
	public AnalogInput tiltActuatorFeedback;
	public AnalogInput ballActuatorFeedback;
		
	public DigitalInput ballSwitch;
	
	//Initialize inputs
	public void init(){
		
		//Joysticks
		leftStick = new Joystick(RobotMap.JOYSTICK_LEFT);
		rightStick = new Joystick(RobotMap.JOYSTICK_RIGHT);
		controller = new Joystick(RobotMap.CONTROLLER);
		
		//Shooter
		intakeBallButton = new JoystickButton(controller, RobotMap.CONT_INTAKE_BUTTON);
		shootBallButton = new JoystickButton(controller, RobotMap.CONT_FIRE_BUTTON);
		
		intakeBallButton.whenPressed(new ShooterHome());
		shootBallButton.whenPressed(new AimAndShoot());	
		
		//Lifter
		lifterUp = new JoystickButton(controller, RobotMap.CONT_LIFTER_UP);
		lifterDown = new JoystickButton(controller, RobotMap.CONT_LIFTER_DOWN);
		
//		lifterUp.whenPressed(new LifterUp());
//		lifterDown.whenPressed(new LifterDown());

		//Camera
		cameraSwitchButton1 = new JoystickButton(controller, RobotMap.CONT_CAM1);
		cameraSwitchButton2 = new JoystickButton(controller, RobotMap.CONT_CAM2);
		
		cameraSwitchButton1.whenPressed(new ChangeCamera(RobotMap.RPI_CAMERA_SET1));
		cameraSwitchButton2.whenPressed(new ChangeCamera(RobotMap.RPI_CAMERA_SET2));
	}
}

