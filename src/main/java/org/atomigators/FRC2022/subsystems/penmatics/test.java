// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.atomigators.FRC2022.subsystems.penmatics;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.atomigators.FRC2022.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/** Add your docs here. */
public class test extends Subsystem {
  private DoubleSolenoid topsolenoid;

  public test() {
    topsolenoid = new DoubleSolenoid(Constants.TOPSOLENOID_FORWARDCHANNEL, Constants.TOPSOLENOID_REVERSECHANNEL);
  }

  public void extend() {
    topsolenoid.set(Value.kForward);
  }
  public void retract() {
    topsolenoid.set(Value.kReverse);
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new Disable());
  }
}
