package org.usfirst.frc.team1350.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//Joysticks
	public static final int JOYSTICK_LEFT = 0;
	public static final int JOYSTICK_RIGHT = 1; 
	public static final int CONTROLLER = 2;
	
	//Motor Controllers
	public static final int DRIVE_TRAIN_LEFT_MOTOR_CONTROLLER = 1;
	public static final int DRIVE_TRAIN_RIGHT_MOTOR_CONTROLLER = 0;
	public static final int SHOOTER_MOTORS = 7;	
	public static final int SHOOTER_TILT_MOTOR = 6;
	public static final int LIFTER_MOTOR = 2;
	public static final int KICKER_MOTOR = 3;

	//Limit Switches
	public static final int SHOOTER_BOTTOM_LIMIT = 6;
	public static final int SHOOTER_TOP_LIMIT = 5;
	public static final int SHOOTER_BALL_SWITCH = 2;
	public static final int LIFTER_TOP_LIMIT = 8;
	public static final int LIFTER_BOTTOM_LIMIT = 7;

	//Encoders
	public static final int SHOOTER_ENCODERA = 3;
	public static final int SHOOTER_ENCODERB = 4;
	
	//Buttons 
	public static final int CONT_CAM1 = 1;
	
	public static final int CONT_CAM2 = 3;
	public static final int CONT_FIRE_BUTTON = 6;
	public static final int CONT_AUTO_FIRE_BUTTON = 8;
	public static final int CONT_INTAKE_BUTTON = 5;
	public static final int CONT_LIFTER_UP = 4;
	public static final int CONT_LIFTER_DOWN = 2;
	//TODO: remove
	public static final int CONT_TEMP_SHOOTER_HOME = 7;
	public static final int CONT_TEMP_KICKER_BUTTON = 9;
	
	//Misc
	public static final int RPI_CAMERA_SET1 = 0;
	public static final int RPI_CAMERA_SET2 = 1;
	
	//Analog
	public static final int RANGEFINDER_PORT = 0;

}