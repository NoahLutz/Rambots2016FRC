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
	
	public static final int SHOOTER_LEFT_MOTOR_CONTROLLER = 2;
	public static final int SHOOTER_RIGHT_MOTOR_CONTROLLER = 3;
	
	public static final int SHOOTER_TILT_LEFT_MOTOR_CONTROLLER = 4;
	public static final int SHOOTER_TILT_RIGHT_MOTOR_CONTROLLER = 5;
	
	public static final int ULTRASONIC_ECHO_PULSE_OUTPUT = 6;
	public static final int ULTRASONIC_TRIGGER_PULSE_INPUT = 7;
	
	public static final int ULTRASONIC_PING = 8;
	public static final int ULTRASONIC_ECHO = 9;
	
	public static final int RPI_CAMERA_SET1 = 0;
	public static final int RPI_CAMERA_SET2 = 1;
	
	//Controller 
	public static final int CONT_CAM1 = 2;
	public static final int CONT_CAM2 = 3;
	

	
	
}