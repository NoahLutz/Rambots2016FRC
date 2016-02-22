package org.usfirst.frc.team1350.robot.commands.shooter;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;

/**
 *
 */
public class ShooterHome extends MoveActuatorServo {
	
	//private static PWM shooterTiltPWM = Shooter.getTiltPWM();
//	private static DigitalOutput shooterTiltDigital = Shooter.getTiltDigital();
	//private static AnalogOutput shooterTiltAnalog = Shooter.getTiltAnalog();
	//private static Servo shooterServo = Shooter.getTiltServo();
	private static Actuator actuator = Shooter.getTiltServo();
	private static AnalogInput shooterTiltFeedback = Shooter.getTiltFeedback();
	private static int homePosition = Shooter.TILT_HOME_PWM;
	private static float timeout = 4f;
	
    public ShooterHome() {
    	super(actuator, shooterTiltFeedback, homePosition, timeout);
    	Log.info("New ShooterHomeAnalog");
    }

}
