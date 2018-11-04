package org.usfirst.frc.team6238.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * Created by abkhanna on 9/21/18.
 */
public class DriveTrainRobotController implements RobotController {
    public DriveTrainRobotController() {


    }


    @Override
    public boolean performAction(RobotProperties properties) {
        // you might want to check for a button that is the Drive Train button.
        boolean isLeftDriveTrainButtonPressed = properties.getLeftStick().getRawButton(1);
        boolean isRightDriveTrainButtonPressed = properties.getRightStick().getRawButton(1);
        if (isLeftDriveTrainButtonPressed || isRightDriveTrainButtonPressed) {
            properties.getMyRobot().tankDrive(properties.getRightStick().getY(), properties.getLeftStick().getY());
            Solenoid driveTrainSolenoid = properties.getDriveTrainSolenoid();
            driveTrainSolenoid.set(true);
        }
        return true;
    }
}
