package org.usfirst.frc.team1350.robot.subsystems;

import org.usfirst.frc.team1350.robot.OI;
import org.usfirst.frc.team1350.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem{

	//Singleton
	private static Lifter instance;
	public static Lifter getInstance(){
		if (instance==null){
			instance = new Lifter();
		}
		return instance;
	}
	
	public static final double SPEED = .25;
	
	public static final boolean FORWARD = true;
	public static final boolean REVERSE = false;
	
	private OI oi;
	
	private Talon motor;
	private DigitalInput bottomLimit;
	private DigitalInput topLimit;
	
	public Lifter(){
		super();
	}
	
	public void init(){
		oi = OI.getInstance();
		
		motor = new Talon(RobotMap.LIFTER_MOTOR);
		
		bottomLimit = new DigitalInput(RobotMap.LIFTER_BOTTOM_LIMIT);
		topLimit = new DigitalInput(RobotMap.LIFTER_TOP_LIMIT);
	}
	
	public boolean bottomLimitIsHit(){
		return bottomLimit.get();
	}
	
	public boolean topLimitIsHit(){
		return topLimit.get();
	}
	
	public void runMotor(double speed, boolean direction){
		if(!direction){
			speed = -(speed);
		}
		motor.set(speed);
	}
	
	public void stopMotor(){
		motor.set(0d);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
