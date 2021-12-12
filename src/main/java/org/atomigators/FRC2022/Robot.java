package org.atomigators.FRC2022;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import org.atomigators.FRC2022.subsystems.penmatics.*;
import org.frcteam2910.common.math.RigidTransform2;
import org.frcteam2910.common.math.Rotation2;
//import org.frcteam2910.common.robot.UpdateManager;
import org.frcteam2910.common.robot.drivers.Limelight;


public class Robot extends TimedRobot {
    private RobotContainer robotContainer = new RobotContainer();
    //private UpdateManager updateManager = new UpdateManager(
    //        robotContainer.getDrivetrainSubsystem()
    //);

    //@Override
    //public void robotInit() {
    //    updateManager.startLoop(5.0e-3);
    //}
    public static Robot instance = null;

    public static Robot getInstance() {
        return instance;
    }

    public static test TEST = new test();

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    //Autonomous command
    @Override
    public void autonomousInit() {
        robotContainer.getVisionSubsystem().setLedMode(Limelight.LedMode.DEFAULT);
        robotContainer.getDrivetrainSubsystem().resetPose(RigidTransform2.ZERO);
        robotContainer.getDrivetrainSubsystem().resetGyroAngle(Rotation2.ZERO);
    }

    @Override
    public void disabledPeriodic() {
        robotContainer.getVisionSubsystem().setLedMode(Limelight.LedMode.OFF);
    }

    //Teleop command
    @Override
    public void teleopInit() {
        robotContainer.getVisionSubsystem().setLedMode(Limelight.LedMode.DEFAULT);
    }
}
