package org.usfirst.frc.team1350.robot.subsystems;

import org.usfirst.frc.team1350.robot.OI;
import org.usfirst.frc.team1350.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Victor;
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
	public static final int TILT_HOME_PWM=235;
	
	public static final float TILT_HOME_VOLTAGE=3.2f;
	public static final float TILT_HOME_POSITION_PRECISION=0.1f;

	private Victor shooterMotors;
	
	private PWM tiltActuator;
	private AnalogInput tiltActuatorFeedback;
	
	private PWM ballActuator;
	private AnalogInput ballFeedback;
	
	private DigitalInput ballSwitch;
	
	//TODO: some sort of sensor for detecting if the ball is in the shooter
	
	public void init(){
		oi = OI.getInstance();
		
		tiltActuator = new PWM(RobotMap.SHOOTER_TILT);
		tiltActuatorFeedback = new AnalogInput(RobotMap.SHOOTER_TILT_FEEDBACK);
		
		ballActuator = new PWM(RobotMap.SHOOTER_BALL_ACTUATOR);
		ballFeedback = new AnalogInput(RobotMap.SHOOTER_BALL_FEEDBACK);
		
		ballSwitch = new DigitalInput(RobotMap.SHOOTER_BALL_SWITCH);
		
		shooterMotors = new VictorSP(RobotMap.SHOOTER_MOTORS);
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
    
    public static AnalogInput getTiltFeedback() {
    	Shooter instance = Shooter.getInstance();
    	
    	return instance.tiltActuatorFeedback;
    }
    
    public static PWM getBallPWM() {
    	Shooter instance = Shooter.getInstance();
    	
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

