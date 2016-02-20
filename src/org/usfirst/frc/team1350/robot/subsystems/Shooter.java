package org.usfirst.frc.team1350.robot.subsystems;

import org.usfirst.frc.team1350.robot.RobotMap;

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

	public static final boolean FORWARD = true;
	public static final boolean REVERSE = false;
	
	private Victor shooterMotors;
	
	private PWM tiltActuator;
	private PWM ballActuator;
	
	
	//TODO: some sort of sensor for detecting if the ball is in the shooter
	
	public void init(){
		shooterMotors = new Victor(RobotMap.SHOOTER_MOTORS);
		
		tiltActuator = new PWM(RobotMap.SHOOTER_TILT_LEFT_ACTUATOR);
		ballActuator = new PWM(RobotMap.SHOOTER_BALL_ACTUATOR);
		
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
		//TODO: look at sensor to see if the ball is in the shooter
		return false;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

