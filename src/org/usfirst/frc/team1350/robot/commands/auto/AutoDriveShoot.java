package org.usfirst.frc.team1350.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveShoot extends CommandGroup {
    
    public  AutoDriveShoot() {
    	//TODO: actually make it shoot
    	addSequential(new AutoDrive());
    	addSequential(new AutoTurn());
    }
}
