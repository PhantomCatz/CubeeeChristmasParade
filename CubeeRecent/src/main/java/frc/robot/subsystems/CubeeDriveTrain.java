// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CubeeDriveTrain extends SubsystemBase {
public static CubeeDriveTrain instance;

  Talon talonLtBack;
  Talon talonLtFront;
  Talon talonRtBack;
  Talon talonRtFront;

  final int TALON_LT_BACK_ID = 0;
  final int TALON_LT_FRONT_ID = 0;
  final int TALON_RT_BACK_ID = 0;
  final int TALON_RT_FRONT_ID = 0;
  
  public MotorControllerGroup LeftMotors;
  public MotorControllerGroup RightMotors;

  public DifferentialDrive Cubee_drive;

  public CubeeDriveTrain() {
    talonLtBack = new Talon(TALON_LT_BACK_ID);
    talonLtFront = new Talon(TALON_LT_FRONT_ID);
    talonRtBack = new Talon(TALON_RT_BACK_ID);
    talonRtFront = new Talon(TALON_RT_FRONT_ID);

    // talonLtBack.setInverted(true);  preparing to invert one side of drivetrain
    // talonLtFront.setInverted(true); preparing to invert one side of drivetrain

    LeftMotors = new MotorControllerGroup(talonLtBack, talonLtFront);
    RightMotors = new MotorControllerGroup(talonRtBack, talonRtFront);

    Cubee_drive = new DifferentialDrive(LeftMotors, RightMotors);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public static CubeeDriveTrain getInstance() {
    if (instance == null) 
    {
      instance = new CubeeDriveTrain();
    }

    return instance;
  }
}
