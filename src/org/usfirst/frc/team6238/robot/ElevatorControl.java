package org.usfirst.frc.team6238.robot;
/*map 2 buttons to the elevator
  while button 1 is pressed: elevator moves up
  while button 2 is pressed: elevator moves down
  release both buttons to stop elevator
  elevator does nothing if both buttons are pressed at the same time

  keep track of the position of the elevator, so you can tell it to stop moving if it has hit the top or the bottom.
        */

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;

public class ElevatorControl implements RobotController {

	private Joystick rightStick, leftStick;
	private boolean isLeftElevatorButtonpressed;
	private boolean isRightElevatorButtonpressed;

	private isLeftElevatorButtonpressed(Joystick stick)
    {
    	isLeftElevatorButtonpressed=stick.getRawButton(); //Todo: need to find button number
    }

	private isLeftElevatorButtonpressed(Joystick stick)
    {
    	isRightElevatorButtonpressed=stick.getRawButton(); //Todo: need to find button number
    }

	@Override
	public boolean performAction(RobotProperties properties) {
		WPI_TalonSRX m_elevator = properties.getM_elevator();
		m_elevator.set(0);
		if (isRightElevatorButtonpressed && isLeftElevatorButtonpressed) {
			m_elevator.set(0);
		} else if (isLeftElevatorButtonpressed) {
			m_elevator.set(-10);
		} else if (isRightElevatorButtonPressed) {
			m_elevator.set(10);
		} else {
			m_elevator.set(0);
		}
		return true;
	}
}