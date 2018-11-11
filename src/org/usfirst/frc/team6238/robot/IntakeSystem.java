package org.usfirst.frc.team6238.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;

/*
 *task: if button is pressed, turn on intake system
 *if button is pressed again, turn off intake system
 */
public class IntakeSystem implements RobotController
{
    // checks if the motors are currently on
    private boolean isMotorOn;
    
    //checks if the solenoid is on
    private boolean isSolenoidrOn;

    // intializes joysticks
    public IntakeSystem()
    {
	isMotorOn = false;
	isSolenoidOn = false;
    }

    public boolean performAction(RobotProperties properties)
    {
	// checks if the buttons are pressed
	boolean isLeftMotorIntakeButtonPressed = leftStick.getRawButton(2);// TODO:map buttons
	boolean isRightMotorReleaseButtonPressed = rightStick.getRawButton(2);// TODO:map buttons

	// intake wheel controlled by right joystick
	WPI_TalonSRX m_green = properties.getM_green(3);

	// intake wheel controlled by left joystick
	WPI_TalonSRX m_green2 = properties.getM_green2(3);

	// solenoid for intake system
	Solenoid solenoid = properties.getSolenoid();
	boolean isSolenoidTriggerPressed = leftStick.getRawButton(3); // TODO:map buttons

	// isOn checks if the motors are currently running
	if (!isMotorOn)
	{
	    if (isLeftMotorIntakeButtonPressed)
	    {
		// takes in cube
		m_green.set(5); // TODO: figure out whether to set positive value or negative value
		m_green2.set(5);
		isOn = true;
	    }
	    // releases cube
	    else if (isRightMotorReleasedButtonPressed)
	    {
		m_green.set(-5);
		m_green2.set(-5);
		isOn = true;
	    }
	}
	// if motors are off and either buttons are pressed, the motors are turned off 
	else
	{
	    if (isLeftMotorIntakeButtonPressed||isRightMotorReleaseButtonPressed)
	    {
		m_green.set(0);
		m_green2.set(0);
		isOn = false;
	    }
	}
	
	// triggers solenoid if the button is pressed and solenoids are off
	if (isSolenoidTriggerPressed && !isSolenoidOn)
	{
	    solenoid.set(true);
	    isSolenoidOn = true;
	} 
	// stops solenoid if the button is pressed and solenoids are on
	else if (isSolenoidTriggerPressed && isSolenoidOn)
	{
	    solenoid.set(false);
	    isSolenoidOn = false;
	}
    }
}
