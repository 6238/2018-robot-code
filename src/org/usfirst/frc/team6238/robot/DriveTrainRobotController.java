package org.usfirst.frc.team6238.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * Created by abkhanna on 9/21/18.
 */
public class DriveTrainRobotController implements RobotController {
    public DriveTrainRobotController() {
        isRightDriveTrainButtonpressed = leftStick.getRawButton(1);//TODO:map buttons
        isLeftDriveTrainButtonpressed = rightStick.getRawButton(1);//TODO:map buttons

    }

    private Joystick rightStick, leftStick;
    private boolean isLeftDriveTrainButtonpressed;
    private boolean isRightDriveTrainButtonpressed;

    @Override
    public boolean performAction(RobotProperties properties) {
        // you might want to check for a button that is the Drive Train button.
        if (isLeftDriveTrainButtonpressed || isLeftDriveTrainButtonpressed) {
            properties.getMyRobot().tankDrive(properties.getRightStick().getY(), properties.getLeftStick().getY());
            Solenoid driveTrainSolenoid = properties.getDriveTrainSolenoid();
            driveTrainSolenoid.set(true);


        }
        else
            {
                return false;
            }
        return true;
    }
}
