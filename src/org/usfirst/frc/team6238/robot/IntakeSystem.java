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
	//checks if the buttons are pressed
	boolean isLeftElevatorButtonpressed = leftStick.getRawButton();// TODO:map buttons
	boolean isRightElevatorButtonpressed = rightStick.getRawButton();// TODO:map buttons

	// intake wheel controlled by right joystick
	WPI_TalonSRX m_green = properties.getM_green();

	// intake wheel controlled by left joystick
	WPI_TalonSRX m_green2 = properties.getM_green2();

	// isOn checks if the motors are currently running
	if (isLeftElevatorButtonpressed && isRightElevatorButtonpressed)
	{
	    // turns motor on if the buttons are pressed and the motors are off
	    if (!isOn)
	    {
		m_green.set(); // TODO: figure out whether to set positive value or negative value
		m_green2.set();
		isOn = true;
	    }
	    // turns motor off if the buttons are pressed and the motors are on
	    else
	    {
		m_green.set(0);
		m_green2.set(0);
		isOn = false;
	    }
	}
    }
}
