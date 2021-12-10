package org.atomigators.FRC2022;

import edu.wpi.first.wpilibj2.command.*;
import org.atomigators.FRC2022.subsystems.drivetrain.commands.*;
import org.atomigators.FRC2022.subsystems.vision.VisionSubsystem;
import org.atomigators.FRC2022.subsystems.drivetrain.DrivetrainSubsystem;
import org.frcteam2910.common.math.Rotation2;
import org.frcteam2910.common.math.Vector2;
//import org.frcteam2910.common.robot.Utilities;
import org.frcteam2910.common.robot.input.Axis;
//import org.frcteam2910.common.robot.input.DPadButton;
import org.frcteam2910.common.robot.input.XboxController;

public class RobotContainer {

    private final XboxController primaryController = new XboxController(Constants.PRIMARY_CONTROLLER_PORT);
    private final XboxController secondaryController = new XboxController(Constants.SECONDARY_CONTROLLER_PORT);

    private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
    private final VisionSubsystem visionSubsystem = new VisionSubsystem(drivetrainSubsystem);


    public RobotContainer() {

        primaryController.getLeftXAxis().setInverted(true);
        primaryController.getRightXAxis().setInverted(true);

        CommandScheduler.getInstance().setDefaultCommand(drivetrainSubsystem, new DriveCommand(drivetrainSubsystem, getDriveForwardAxis(), getDriveStrafeAxis(), getDriveRotationAxis()));
        CommandScheduler.getInstance().registerSubsystem(visionSubsystem);

        configureButtonBindings();
    }

    private void configureButtonBindings() {
        primaryController.getBackButton().whenPressed(
                () -> drivetrainSubsystem.resetGyroAngle(Rotation2.ZERO)
        );


        primaryController.getAButton().whenPressed(
                new BasicDriveCommand(drivetrainSubsystem, new Vector2(-0.5, 0.0), 0.0, false).withTimeout(0.12)
        );
    }

    private Axis getDriveForwardAxis() {
        return primaryController.getLeftYAxis();
    }

    private Axis getDriveStrafeAxis() {
        return primaryController.getLeftXAxis();
    }

    private Axis getDriveRotationAxis() {
        return primaryController.getRightXAxis();
    }

    public DrivetrainSubsystem getDrivetrainSubsystem() {
        return drivetrainSubsystem;
    }

    public VisionSubsystem getVisionSubsystem() { return  visionSubsystem; }

    public XboxController getPrimaryController() {
        return primaryController;
    }

    public XboxController getSecondaryController() {
        return secondaryController;
    }
}
