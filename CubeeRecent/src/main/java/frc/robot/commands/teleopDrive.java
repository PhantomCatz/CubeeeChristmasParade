// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CubeeDriveTrain;

public class teleopDrive extends CommandBase {
  public CubeeDriveTrain driveTrain = CubeeDriveTrain.getInstance();
  Supplier<Double> leftYStickSupplier;
  Supplier<Double> rightXStickSupplier;

  public teleopDrive(Supplier<Double> leftYStickSupplier,
                     Supplier<Double> rightXStickSupplier) 
  {
    // Use addRequirements() here to declare subsystem dependencies.
    this.leftYStickSupplier = leftYStickSupplier;
    this.rightXStickSupplier = rightXStickSupplier;
    
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftStickPower = leftYStickSupplier.get();
    double rightStickPower = rightXStickSupplier.get();
    
    driveTrain.Cubee_drive.arcadeDrive(leftStickPower, rightStickPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
