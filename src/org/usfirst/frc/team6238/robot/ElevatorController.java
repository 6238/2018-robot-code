package org.usfirst.frc.team6238.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ElevatorController implements RobotController {
	private boolean isElevatorButtonPressed;
	private boolean isElevateDownButtonPressed;
	@Override
	public boolean performAction(RobotProperties properties) {
		isElevatorButtonPressed = properties.getRightStick().getRawButton(5);
		isElevateDownButtonPressed = properties.getLeftStick().getRawButton(4);
		//creates a button and set it to port four, returns true if Button is pressed
		if(isElevatorButtonPressed) {
			elevateUp(properties.getElevatorTalon());
		}
		else if(isElevateDownButtonPressed)
		{
			elevateDown(properties.getElevatorTalon());
		}
		else
		{
			elevatorStop(properties.getElevatorTalon());
		}
		return true;
	}
	
	public void elevateUp(WPI_TalonSRX elevatorTalon) {
		elevatorTalon.set(5);
	}
	public void elevateDown(WPI_TalonSRX elevatorTalon)
	{
		elevatorTalon.set(-5);
	}
	public void elevatorStop(WPI_TalonSRX elevatorTalon)
	{
		elevatorTalon.set(0);
	}
	
	
}
