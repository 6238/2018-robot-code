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
public class IntakeSystem implements RobotController{
	
	//takes input from joysticks
	private Joystick rightStick, leftStick;
	
	//intake wheel controlled by right joystick
	private WPI_TalonSRX m_green;
    
	//intake wheel controlled  by left joystick
	private WPI_TalonSRX m_green2;
	
	//intializes joysticks
	public IntakeSystem()
    {
    	isLeftElevatorButtonpressed=leftStick.getRawButton();//TODO:map buttons 
    	isRightElevatorButtonpressed=rightStick.getRawButton();//TODO:map buttons
    }
	
	public boolean performAction(RobotProperties properties) {
		//gets the motors from properties
		m_green = properties.getM_green();
		m_green2 = properties.getM_green2();
		
		//isOn checks if the motors are currently running
		boolean isOn = false;
		if(isLeftElevatorButtonpressed && isRightElevatorButtonpressed)
		{
			//turns motor on if the buttons are pressed and the motors are off
			if(!isOn)
			{
				m_green.set(); //TODO: figure out whether to set positive value or negative value
				m_green2.set();
				isOn=true;
			}
			//turns motor off if the buttons are pressed and the motors are on
			else
			{
				m_green.set(0);
				m_green2.set(0);
				isOn = false;
			}
		}
	}
}
