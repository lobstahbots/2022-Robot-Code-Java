// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands.drive;

import frc.robot.subsystems.DriveBase;
import java.util.function.Supplier;

public class ArcadeDriveCommand extends DriveCommand {

  private final Supplier<Double> linearSpeedSupplier;
  private final Supplier<Double> angularSpeedSupplier;

  public ArcadeDriveCommand(DriveBase driveBase, Supplier<Double> linearSpeedSupplier, Supplier<Double> angularSpeedSupplier) {
    super(driveBase);
    this.linearSpeedSupplier = linearSpeedSupplier;
    this.angularSpeedSupplier = angularSpeedSupplier;
    addRequirements(this.driveBase);
  }

  public ArcadeDriveCommand(DriveBase driveBase, double linearSpeed, double angularSpeed) {
    this(driveBase, () -> linearSpeed, () -> angularSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveBase.arcadeDrive(linearSpeedSupplier.get(), angularSpeedSupplier.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveBase.stopDrive();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
