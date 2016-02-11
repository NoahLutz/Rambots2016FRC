package org.usfirst.frc.team1350.robot;

import org.usfirst.frc.team1350.robot.commands.ChangeCamera;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
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
	public Joystick controller;
	
	public Button cameraSwitchButton1;
	public Button cameraSwitchButton2;
	public Button cameraSwitchButton3;
	public Button cameraSwitchButton4;
	
	//Initialize inputs
	public void init(){
		leftStick = new Joystick(RobotMap.JOYSTICK_LEFT);
		rightStick = new Joystick(RobotMap.JOYSTICK_RIGHT);
		controller = new Joystick(RobotMap.CONTROLLER);
		
		cameraSwitchButton1 = new JoystickButton(controller, RobotMap.CONT_CAM1);
		cameraSwitchButton2 = new JoystickButton(controller, RobotMap.CONT_CAM2);
		cameraSwitchButton3 = new JoystickButton(controller, RobotMap.CONT_CAM3);
		cameraSwitchButton4 = new JoystickButton(controller, RobotMap.CONT_CAM4);
		
		cameraSwitchButton1.whenPressed(new ChangeCamera(RobotMap.RPI_CAMERA1));
		cameraSwitchButton2.whenPressed(new ChangeCamera(RobotMap.RPI_CAMERA2));
		cameraSwitchButton3.whenPressed(new ChangeCamera(RobotMap.RPI_CAMERA3));
		cameraSwitchButton4.whenPressed(new ChangeCamera(RobotMap.RPI_CAMERA4));

	}
}

