package org.usfirst.frc.team1350.robot.subsystems;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.OI;
import org.usfirst.frc.team1350.robot.RobotMap;
import org.usfirst.frc.team1350.robot.commands.shooter.SetShooterToHigh;
import org.usfirst.frc.team1350.robot.utils.Utils;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends PIDSubsystem {
    
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
	public static final boolean TILT_FORWARD = false;
	public static final boolean TILT_REVERSE = true;
	// TODO adjust
	public static final float TILT_HOME_POSITION_PRECISION=0.1f;

	private VictorSP shooterMotors;
	private DigitalInput ballSwitch;
	
	private Encoder encoder;
	private boolean homeIsFound = false;
	private int encoderHomePosition = 0;
	
	private PIDController tiltPIDLoop;
	private Talon tiltMotor;
	private DigitalInput bottomLimit;
	private DigitalInput topLimit;
	
	private Talon kickerMotor;
	
	public Shooter() {
		//TODO: try larger P
		//TODO: if that doesn't work try adding a I value
		super("Shooter", 10.0, 0.0, 0.0);
		getPIDController().setContinuous(false);
		setAbsoluteTolerance(5);
//		init();
	}
	
	public void init(){
		oi = OI.getInstance();
	
		shooterMotors = new VictorSP(RobotMap.SHOOTER_MOTORS);
		
		tiltMotor = new Talon(RobotMap.SHOOTER_TILT_MOTOR);
		encoder = new Encoder(RobotMap.SHOOTER_ENCODERA, RobotMap.SHOOTER_ENCODERB, true, Encoder.EncodingType.k4X);
		encoder.reset();
				
		ballSwitch = new DigitalInput(RobotMap.SHOOTER_BALL_SWITCH);
		bottomLimit = new DigitalInput(RobotMap.SHOOTER_BOTTOM_LIMIT);
		topLimit = new DigitalInput(RobotMap.SHOOTER_TOP_LIMIT);
		
		kickerMotor = new Talon(RobotMap.KICKER_MOTOR);
		
		// TODO figure out PID control later
//		tiltPIDLoop = new PIDController(1, 0, 0, encoder, tiltMotor);
//		tiltPIDLoop.setOutputRange(-0.5, 0.5);

		
		// TODO move to autonomous start?
//		findHome();
		
		Log.info("Exiting Shooter.init");
	}
	
	public void findHome() {
		// TODO move to home, call reset on the encoder
		
		// TODO figure out when to call home command 
//		SetShooterToHigh shooterHomeCommand = new SetShooterToHigh();
//		shooterHomeCommand.start();
		encoder.reset();
	}
	
	public boolean isAnyLimitHit() {
		return topLimitIsHit() || bottomLimitIsHit();
	}
	
	public static double convertAngleToEncoderSteps(double angle) {
		// Calculate # of encoder values is needed for desired angle
		//TODO: chnange this based on new encoder
		double ticksPerRevolution = 10000;
		double encoderTicks = Utils.remap(angle, 0, 360, 0, ticksPerRevolution);
		
		return encoderTicks;
	}
	
	//if direction is set to false, it will run in reverse
	public void runShooterMotor(double speed, boolean direction){
		if(!direction){
			//reverse the direction
			speed = -(speed);
		}
		shooterMotors.set(speed);
	}
	
	public int getCurrentShooterTilt() {
		int encoderPosition = encoder.get();
//		Log.info("EncoderPosition, " + encoderPosition);
//		Log.info("Encoder," + encoder.getRaw());
		return encoderPosition;
	}
	
	public void stopShooterMotors(){
		shooterMotors.set(0d);
	}
	
	public boolean ballIsInShooter(){
		return ballSwitch.get();
	}
	
    public DigitalInput getBallSwitch() {
    	Shooter instance = Shooter.getInstance();
    	
    	return instance.ballSwitch;
    }
    
    public void runTiltMotors(double speed, boolean direction){
//    	Log.info("encoder val: " + Integer.toString(getCurrentShooterTilt()));
//    	Log.info("runTiltMotors, " + speed + ", Dir: " + direction);
//    	Log.info("running tilt motors");
    	if(!direction){
    		speed = -(speed);
    	}
    	tiltMotor.set(speed);
    }
    
    public boolean bottomLimitIsHit(){
    	return bottomLimit.get();
    }
    
    public boolean topLimitIsHit(){
    	return topLimit.get();
    }
    
    public void resetEncoder(){
    	encoder.reset();
    }
    
    public void stopTiltMotors(){
    	tiltMotor.set(0d);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public void kickBall() {
		// TODO Auto-generated method stub
		kickerMotor.set(1);
	}
    
	public void stopKickingBall() {
		kickerMotor.set(0);
	}

	@Override
	protected double returnPIDInput() {
		return getCurrentShooterTilt();
	}

	@Override
	protected void usePIDOutput(double output) {
		tiltMotor.pidWrite(-output);
	}
}

