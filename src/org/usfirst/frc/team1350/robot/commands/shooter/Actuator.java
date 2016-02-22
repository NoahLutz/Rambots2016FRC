package org.usfirst.frc.team1350.robot.commands.shooter;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Servo;

public class Actuator extends Servo {

	// TODO use white wire for actuator
	public Actuator(int channel) {
		super(channel);
		//setBounds(2d, 0, 0, 0, 1d);
		//setBounds(2d, 1.6, 1.5, 1.4, 1d);
		//setBounds(255, 129, 128, 127, 0);
		this.setPeriodMultiplier(PWM.PeriodMultiplier.k4X);
	}

}
