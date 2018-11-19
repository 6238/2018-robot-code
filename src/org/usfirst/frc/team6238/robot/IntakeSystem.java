package org.usfirst.frc.team6238.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;


public class IntakeSystem implements RobotController
{
    private Joystick rightStick, leftStick;
    // checks if the motors are currently on
    private boolean isOn;

    public IntakeSystem()
    {
        isOn = false;
    }

    public boolean performAction(RobotProperties properties)
    {
        //checks if the buttons are pressed
        Solenoid Solenoid = properties.getSolenoid();
        boolean isLeftElevatorButtonPressed = leftStick.getRawButton(2);
        boolean isRightElevatorButtonPressed = rightStick.getRawButton(2);
        boolean isLeftIntakeButtonPressed = leftStick.getRawButton(6);
        boolean isRightIntakeButtonPressed = rightStick.getRawButton(6);


        // intake wheel controlled by right joystick
        WPI_TalonSRX m_green = properties.getM_green();

        // intake wheel controlled by left joystick
        WPI_TalonSRX m_green2 = properties.getM_green2();

        // isOn checks if the motors are currently running
        if (isRightElevatorButtonPressed)
        {
            // turns motor on if the buttons are pressed and the motors are off
            if (!isOn)
            {
                m_green.set(5);
                m_green2.set(5);
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
        else if(isLeftElevatorButtonPressed )
        {
            if (!isOn)
            {
                m_green.set(-5);
                m_green2.set(-5);
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
        else
        {
            m_green.set(0);
            m_green2.set(0);
            isOn = false;
        }

        if (isRightIntakeButtonPressed && !isLeftIntakeButtonPressed)
        {

            Solenoid.set(true);

        }
        else if(isLeftIntakeButtonPressed && !isRightIntakeButtonPressed)
        {
            Solenoid.set(false);
        }
        return true;
    }
}