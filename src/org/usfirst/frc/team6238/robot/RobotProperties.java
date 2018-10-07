package org.usfirst.frc.team6238.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotProperties {

    private Timer timer;
    private Joystick leftStick, rightStick;
    private DifferentialDrive myRobot;
    private SpeedControllerGroup m_left;
    private SpeedControllerGroup m_right;

    //green wheels controlled by right controller
    private WPI_TalonSRX m_green;

    //green wheels controlled by left controller
    private WPI_TalonSRX m_green2;
    private Solenoid solenoid;
    private Solenoid driveTrainSolenoid;
    public RobotProperties() {
        this.timer = new Timer();
        rightStick = new Joystick(0);
        leftStick = new Joystick(1);
        solenoid = new Solenoid(1);
        driveTrainSolenoid = new Solenoid(0);
        
        WPI_TalonSRX m_frontLeft = new WPI_TalonSRX(34);
        WPI_TalonSRX m_rearLeft = new WPI_TalonSRX(33);
        WPI_TalonSRX m_midLeft = new WPI_TalonSRX(34);
        WPI_TalonSRX m_elevator = new WPI_TalonSRX(35);
        
        m_green = new WPI_TalonSRX(37);
        m_green2 = new WPI_TalonSRX(38);
        m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft, m_midLeft);

        WPI_TalonSRX m_frontRight = new WPI_TalonSRX(32);
        WPI_TalonSRX m_rearRight = new WPI_TalonSRX(36);
        WPI_TalonSRX m_midRight =  new WPI_TalonSRX(32);
        m_right = new SpeedControllerGroup(m_frontRight, m_rearRight, m_midRight);

        myRobot = new DifferentialDrive(m_left, m_right);
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public Joystick getLeftStick() {
        return leftStick;
    }

    public void setLeftStick(Joystick leftStick) {
        this.leftStick = leftStick;
    }

    public Joystick getRightStick() {
        return rightStick;
    }

    public void setRightStick(Joystick rightStick) {
        this.rightStick = rightStick;
    }

    public DifferentialDrive getMyRobot() {
        return myRobot;
    }

    public void setMyRobot(DifferentialDrive myRobot) {
        this.myRobot = myRobot;
    }

    public SpeedControllerGroup getM_left() {
        return m_left;
    }

    public void setM_left(SpeedControllerGroup m_left) {
        this.m_left = m_left;
    }

    public SpeedControllerGroup getM_right() {
        return m_right;
    }

    public void setM_right(SpeedControllerGroup m_right) {
        this.m_right = m_right;
    }

    public WPI_TalonSRX getM_green() {
        return m_green;
    }

    public void setM_green(WPI_TalonSRX m_green) {
        this.m_green = m_green;
    }

    public WPI_TalonSRX getM_green2() {
        return m_green2;
    }

    public void setM_green2(WPI_TalonSRX m_green2) {
        this.m_green2 = m_green2;
    }

    public Solenoid getSolenoid() {
        return solenoid;
    }

    public void setSolenoid(Solenoid solenoid) {
        this.solenoid = solenoid;
    }
    
    public Solenoid getDriveTrainSolenoid() {
    	return driveTrainSolenoid;
    }
    
    public WPI_TalonSRX getM_elevator()
    {
    	return m_elevator;
    }
    public void setDriveTrainSolenoid(Solenoid driveTrainSolenoid) {
        this.solenoid = driveTrainSolenoid;
    }
}
