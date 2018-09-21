package org.usfirst.frc.team6238.robot;

/**
 * Created by abkhanna on 9/21/18.
 */
public class DriveTrainRobotController implements RobotController {

    @Override
    public boolean performAction(RobotProperties properties) {
        // you might want to check for a button that is the Drive Train button.
        properties.getMyRobot().tankDrive(properties.getRightStick().getY(), properties.getLeftStick().getY());
        return true;
    }

}
