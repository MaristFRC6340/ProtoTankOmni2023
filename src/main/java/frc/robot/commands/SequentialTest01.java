// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SequentialTest01 extends SequentialCommandGroup {
  /** Creates a new SequentialTest01. */

  public SequentialTest01(DriveTrain driveTrain) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(

      // Backup 1
      new EncoderDriveCommand(driveTrain, -1, 0.2),

      // Turn Left 90
      new EncoderTurnCommand(driveTrain, -86, 0.1),

      // Forward 1.5 Feet
      new EncoderDriveCommand(driveTrain, 2.5, 0.3),

      // Turn 90 Degrees
      new EncoderTurnCommand(driveTrain, -86, 0.1),

      // Aim Time - Point at Cone
      new AimTimeCommand(driveTrain, 0.2, 2),

      // Forward 16 Feet
      new EncoderDriveCommand(driveTrain, 16, 0.4),

      // Turn 180
      //new EncoderTurnCommand(driveTrain, -180, 0.1),

      // Forward 16 Feet
      new EncoderDriveCommand(driveTrain, -16, 0.4),

      // turn Left 90
      new EncoderTurnCommand(driveTrain, -84, 0.1),

      // Forward 3
      new EncoderDriveCommand(driveTrain, 3, 0.2),

      // turn Left 90
      new EncoderTurnCommand(driveTrain, -84, 0.1)

    );
  }
}
