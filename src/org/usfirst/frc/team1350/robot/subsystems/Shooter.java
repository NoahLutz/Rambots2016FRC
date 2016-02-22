package org.usfirst.frc.team1350.robot.subsystems;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.OI;
import org.usfirst.frc.team1350.robot.RobotMap;
import org.usfirst.frc.team1350.robot.commands.shooter.Actuator;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//singleton
	private static Shooter instance;
	public static Shooter getInstance(){
		if (instance==null){
			instance = new Shooter();
		}
		return instance;
	}

	private static OI oi;
	
	public static final boolean FORWARD = true;
	public static final boolean REVERSE = false;
	
	// TODO adjust
	public static final int TILT_SHOOT_PWM=1;
	public static final int TILT_HOME_PWM=255;
	
	public static final float TILT_HOME_POSITION_PRECISION=0.1f;

	private VictorSP shooterMotors;
	
	private PWM tiltActuator;
	private DigitalOutput tiltDigitalActuator;
	private AnalogOutput tiltAnalogActuator;
	private Actuator tiltActuatorServo;
	private AnalogInput tiltActuatorFeedback;
	
	private PWM ballActuator;
	private AnalogInput ballFeedback;
	
	private DigitalInput ballSwitch;
	
	//TODO: some sort of sensor for detecting if the ball is in the shooter
	
	public Shooter() {
		init();
	}
	
	public void init(){
		oi = OI.getInstance();
		
		//tiltActuator = new PWM(RobotMap.SHOOTER_TILT);
//		Log.info("Setting Position to 255");
//		tiltDigitalActuator = new DigitalOutput(RobotMap.SHOOTER_TILT);
//		tiltDigitalActuator.enablePWM(0);
//		tiltDigitalActuator.setPWMRate(1000);
		tiltActuatorServo = new Actuator(RobotMap.SHOOTER_TILT);
		
		tiltActuatorFeedback = new AnalogInput(RobotMap.SHOOTER_TILT_FEEDBACK);
		
		ballActuator = new PWM(RobotMap.SHOOTER_BALL_ACTUATOR);
		ballFeedback = new AnalogInput(RobotMap.SHOOTER_BALL_FEEDBACK);
		
		ballSwitch = new DigitalInput(RobotMap.SHOOTER_BALL_SWITCH);
		
		shooterMotors = new VictorSP(RobotMap.SHOOTER_MOTORS);
		Log.info("Exiting Shooter.init");
	}
	
	public int getCurrentRawTiltPWM(){
		return tiltActuator.getRaw();
	}
	
	public void setRawTiltPWM(int value){
		//252 for fully extended 
		//127 for fully retracted
		tiltActuator.setRaw(value);
	}
	
	public int getCurrentRawBallPWM(){
		return ballActuator.getRaw();
	}
	
	public void setRawBallPWM(int value){
		//252 for fully extended 
		//127 for fully retracted
		ballActuator.setRaw(value);
	}
	
	//if direction is set to false, it will run in reverse
	public void runShooterMotor(double speed, boolean direction){
		if(!direction){
			//reverse the direction
			speed = -(speed);
		}
		
		shooterMotors.set(speed);
	}
	
	public void stopShooterMotors(){
		shooterMotors.set(0.0);
	}
	
	public boolean ballIsInShooter(){
		// look at sensor to see if the ball is in the shooter
		return ballSwitch.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public static PWM getTiltPWM() {
    	Shooter instance = Shooter.getInstance();
    	
    	return instance.tiltActuator;
    }
    
    public static DigitalOutput getTiltDigital() {
    	Shooter instance = Shooter.getInstance();
    	
    	return instance.tiltDigitalActuator;
    }
    
    public static AnalogOutput getTiltAnalog() {
    	Shooter instance = Shooter.getInstance();
    	
    	return instance.tiltAnalogActuator;
    }
    
    public static Actuator getTiltServo() {
    	Shooter instance = Shooter.getInstance();
    	
    	return instance.tiltActuatorServo;
    }
    
    public static AnalogInput getTiltFeedback() {
    	Shooter instance = Shooter.getInstance();
    	
    	return instance.tiltActuatorFeedback;
    }
    
    public static PWM getBallPWM() {
    	Log.info("Called GetBallPWM");
    	Shooter instance = Shooter.getInstance();
    	Log.info("PWM: " + instance.ballActuator);
    	
    	return instance.ballActuator;
    }
    
    public static AnalogInput getBallFeedback() {
    	Shooter instance = Shooter.getInstance();
    	
    	return instance.ballFeedback;
    }
    
    public static DigitalInput getBallSwitch() {
    	Shooter instance = Shooter.getInstance();
    	
    	return instance.ballSwitch;
    }
    
}

