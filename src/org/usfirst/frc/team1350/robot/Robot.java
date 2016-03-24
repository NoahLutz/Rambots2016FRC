
package org.usfirst.frc.team1350.robot;

import org.usfirst.frc.team1350.robot.commands.auto.AutoDrive;
import org.usfirst.frc.team1350.robot.commands.auto.AutoDriveShoot;
import org.usfirst.frc.team1350.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1350.robot.subsystems.Lifter;
import org.usfirst.frc.team1350.robot.subsystems.RangeFinder;
import org.usfirst.frc.team1350.robot.subsystems.Shooter;
import org.usfirst.frc.team1350.robot.subsystems.RaspberryPi;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
    public static Drivetrain drivetrain;
    public static Shooter shooter;
    public static Lifter lifter;
    public static RangeFinder rangeFinder;
    public CameraServer camera;
    public static RaspberryPi raspi;

    Command autonomousCommand;
    SendableChooser chooser;
    
    public Robot(){
    	//start camera server and start auto capture
    	camera = CameraServer.getInstance();
    	camera.setQuality(50);
//		camera.startAutomaticCapture("cam1");
		camera.startAutomaticCapture("cam0");

    	Log.info("Initializing Robot");
    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	//Initilaze subsystems and oi
    	raspi = new RaspberryPi().getInstance();
		raspi.init();
		oi = OI.getInstance();
		oi.init();
		drivetrain = Drivetrain.getInstance();
		drivetrain.init();
		shooter = Shooter.getInstance();
		shooter.init();
		lifter = Lifter.getInstance();
		lifter.init();
		rangeFinder = RangeFinder.getInstance();
		rangeFinder.init();
		
		
		//define autonomous chooser
        chooser = new SendableChooser();
        chooser.addDefault("Drive", new AutoDrive());
//        chooser.addObject("Drive and Shoot", new AutoDriveShoot());
        SmartDashboard.putData("Auto mode", chooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	shooter.stopShooterMotors();
    	raspi.turnOffCameras();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		
		//TODO: add other auto methods
		switch(autoSelected) {
		case "Drive and Shoot":
			Log.info("Using AutoDriveShoot");
			autonomousCommand = new AutoDriveShoot();
			break;
		case "Drive":
		default:
			Log.info("Using AutoDrive");
			autonomousCommand = new AutoDrive();
			break;
		}
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
