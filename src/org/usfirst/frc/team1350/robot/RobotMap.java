package org.usfirst.frc.team1350.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	
	public static final int DRIVE_TRAIN_LEFT_MOTOR_CONTROLLER = 1;
	public static final int DRIVE_TRAIN_RIGHT_MOTOR_CONTROLLER = 0;
	
	public static final int JOYSTICK_LEFT = 0;
	public static final int JOYSTICK_RIGHT = 1; 
	public static final int CONTROLLER = 2;
	
	//TODO Adjust
	public static final int SHOOTER_MOTORS = 7;	
	public static final int SHOOTER_TILT_MOTOR = 2;
	public static final int SHOOTER_BOTTOM_LIMIT = 6;
	public static final int SHOOTER_TOP_LIMIT = 5;
	public static final int SHOOTER_ENCODERA = 3;
	public static final int SHOOTER_ENCODERB = 4;

	public static final int RANGEFINDER_PORT = 2;
	
	public static final int LIFTER_MOTOR = 6;
	public static final int LIFTER_TOP_LIMIT = 7;
	public static final int LIFTER_BOTTOM_LIMIT = 8;
	
	
	//Digital 
	public static final int SHOOTER_BALL_SWITCH = 2;
	
	//TEMP
	public static final int CONT_FIRE_BUTTON = 1;
	public static final int CONT_REV_BUTTON = 2;
	public static final int CONT_CANCEL = 2;
	
	public static final int KICKER_MOTOR = 3;
	
	public static final int RPI_CAMERA_SET1 = 0;
	public static final int RPI_CAMERA_SET2 = 1;
	
	//Controller 
	public static final int CONT_CAM1 = 2;
	public static final int CONT_CAM2 = 3;
	

	
	
}