package org.usfirst.frc.team6238.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;

/*
 *task: if button is pressed, turn on intake system
 *if button is pressed again, turn off intake system
 *
 *TODO: talk with drivers to figure what buttons to use
 *different speed settings?
 */
public class IntakeSystem implements RobotController
{
    // checks if the motors are currently on
    private boolean isOn;

    // intializes joysticks
    public IntakeSystem()
    {
	isOn = false;
    }

    public boolean performAction(RobotProperties properties)
    {
	// checks if the buttons are pressed
	boolean isLeftElevatorIntakeButtonPressed = leftStick.getRawButton(2);// TODO:map buttons
	boolean isRightElevatorReleaseButtonPressed = rightStick.getRawButton(2);// TODO:map buttons

	// intake wheel controlled by right joystick
	WPI_TalonSRX m_green = properties.getM_green();

	// intake wheel controlled by left joystick
	WPI_TalonSRX m_green2 = properties.getM_green2();

	// solenoid for intake system
	Solenoid solenoid = properties.getSolenoid();
	boolean isSolenoidTriggerPressed = leftStick.getRawButton(); // TODO:map buttons
	boolean isSolenoidTriggerOffPressed = leftStick.getRawButton(); // TODO:map buttons

	// isOn checks if the motors are currently running
	if (!isOn)
	{
	    if (isLeftElevatorIntakeButtonPressed)
	    {
		// takes in cube
		m_green.set(5); // TODO: figure out whether to set positive value or negative value
		m_green2.set(5);
		isOn = true;
	    }
	    // releases cube
	    else if (isRightElevatorIntakeButtonPressed)
	    {
		m_green.set(-5);
		m_green2.set(-5);
		isOn = true;
	    }
	}
	else
	{
	    if (isLeftElevatorIntakeButtonPressed||isRightElevatorIntakeButtonPressed)
	    {
		m_green.set(0);
		m_green2.set(0);
		isOn = false;
	    }
	}
	// triggers solenoid if the on button is pressed and off button is not
	if (isSolenoidTriggerPressed && !isSolenoidTriggerOffPressed)
	{
	    solenoid.set(true);
	} else if (isSolenoidTriggerOffPressed)
	{
	    solenoid.set(false);
	}
    }
}
