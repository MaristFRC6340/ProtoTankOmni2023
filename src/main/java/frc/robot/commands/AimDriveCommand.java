// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AimDriveCommand extends CommandBase {
  /** Creates a new AimDriveCommand. */

  private DriveTrain drivetrain;
  private long startTime;
  private double duration;
  private double power;

  private PhotonCamera camera = new PhotonCamera("Live!_Cam_Sync_HD_VF0770");

  public AimDriveCommand(DriveTrain dtrain, double time) { //may need 2 powers for turn and drive
    // Use addRequirements() here to declare subsystem dependencies.

    drivetrain = dtrain;
    duration = time;
    //power = pwr; need 2?
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  //startTime = System.currentTimeMillis(); //VariableDeclaratorId expected

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
