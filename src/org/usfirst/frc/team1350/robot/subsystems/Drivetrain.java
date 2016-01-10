package org.usfirst.frc.team1350.robot.subsystems;

import org.usfirst.frc.team1350.robot.Log;
import org.usfirst.frc.team1350.robot.commands.TeleOpTankDrive;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem{
	
	//Singleton
	private static Drivetrain instance;
	public Drivetrain getInstance(){
		if (instance==null){
			instance = new Drivetrain();
		}
		return instance;
	}
	
	private TeleOpTankDrive tankDrive;
	
	private Drivetrain(){
		Log.info("Initialized singleton of: " + this.getClass().getCanonicalName());
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
