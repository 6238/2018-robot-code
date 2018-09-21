/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6238.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */

//link for .getY() and .getX() 
//http://first.wpi.edu/FRC/roborio/development/docs/java/edu/wpi/first/wpilibj/GenericHID.html#getY--
/**
 * public final double getY()
Get the y position of the HID.
Returns:
the y position
 *
 */

public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	
	Timer timer;
	Joystick rightStick, leftStick;
	DifferentialDrive myRobot;
	SpeedControllerGroup m_left;
	SpeedControllerGroup m_right;
	 
	//green wheels controlled by right controller 
	
	WPI_TalonSRX m_green;
	
	//green wheels controlled by left controller
	
	WPI_TalonSRX m_green2; 
	Solenoid solenoid;
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
		
		timer = new Timer();
		
		//joystick 0 is the right one
		//joystick 1 is the right one
		
		rightStick = new Joystick(0);
		leftStick = new Joystick(1);
		
		//
		
		solenoid = new Solenoid(1);
		
		WPI_TalonSRX m_frontLeft = new WPI_TalonSRX(34);
		WPI_TalonSRX m_rearLeft = new WPI_TalonSRX(33);
		WPI_TalonSRX m_midLeft = new WPI_TalonSRX(34);
		m_green = new WPI_TalonSRX(37);
		m_green2 = new WPI_TalonSRX(38);
		//30,33,34,35
		//12786
		m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft, m_midLeft);
		WPI_TalonSRX m_frontRight = new WPI_TalonSRX(32);
		WPI_TalonSRX m_rearRight = new WPI_TalonSRX(36);
		WPI_TalonSRX m_midRight =  new WPI_TalonSRX(32);
		m_right = new SpeedControllerGroup(m_frontRight, m_rearRight, m_midRight);
		myRobot = new DifferentialDrive(m_left, m_right);
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
		
		timer.reset();
		timer.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		switch (m_autoSelected) {
			case kCustomAuto:
				// Put custom auto code here
				break;
			case kDefaultAuto:
			default:
				// Put default auto code here
				break;
		}
		//System.out.println(timer.get());
		if(timer.get() < 2.0)
		{
			System.out.println("hello aditi!");
			myRobot.tankDrive(0.5, -0.5);
		}
		else
		{
			myRobot.tankDrive(0, 0);
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	/**
	 * TODO: 
	 * 1)if stick 1 passes a certain value, then the speed of the green wheels is set to a constant speed
	 * 2)figure you the range of the values that getY() returns
	 */
	public void teleopPeriodic() {
		boolean isLeftTriggerPressed;
		boolean isRightTriggerPressed;
		boolean isSolenoidTriggerPressed;
		isRightTriggerPressed = rightStick.getTrigger();
		isLeftTriggerPressed = leftStick.getTrigger();
		isSolenoidTriggerPressed = leftStick.getRawButton(4);
		boolean isSolenoidTriggerOffPressed = rightStick.getRawButton(4);
		
		/*checks if right trigger is pressed
		sets motor for green wheels to how far 
		forward or back the controller is pushed 
		on the y axis*/
		
		if(isRightTriggerPressed)
		{
			double rightStickVal = rightStick.getY();
			if(Math.abs(rightStickVal)<10)
			{
				m_green.set(0);
			}
			//TODO: what does "tankDrive(0,0);" do
			//Guess: stops the green wheels from moving
			
			myRobot.tankDrive(0, 0);
		}
		else if(isLeftTriggerPressed)
		{
			m_green2.set(leftStick.getY());
			myRobot.tankDrive(0,0);
		}
		else
		{
			//if the triggers aren't pressed, the main robot wheels will move according to the controller
			
			myRobot.tankDrive(rightStick.getY(), leftStick.getY());
		}
		if(isSolenoidTriggerPressed && !isSolenoidTriggerOffPressed)
		{
			solenoid.set(true);
		} else if (isSolenoidTriggerOffPressed) {
			solenoid.set(false);
		}
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
