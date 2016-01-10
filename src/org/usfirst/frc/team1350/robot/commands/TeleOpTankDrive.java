package org.usfirst.frc.team1350.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class TeleOpTankDrive extends Command{
	
	//Singleton
	private TeleOpTankDrive instance;
	public TeleOpTankDrive getInstance(){
		if (instance==null){
			instance = new TeleOpTankDrive();
		}
		return instance;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
