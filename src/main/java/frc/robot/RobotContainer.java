// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AimDriveCommand;
import frc.robot.commands.AimTimeCommand;
import frc.robot.commands.EncoderDriveCommand;
import frc.robot.commands.EncoderTurnCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.SequentialTest01;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  //Create Subsystems and assign to Commands
  private final DriveTrain driveTrain = new DriveTrain();
  private final TankDrive m_tankDrive = new TankDrive(driveTrain);
  private final AimTimeCommand m_AimTimeCommand = new AimTimeCommand(driveTrain, 0.2, 30);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_AimTimeCommand;
  }

  public Command getTeleopCommand() {
    return m_tankDrive;
  }

  public Command getEncoderTurnCommand() {
    return new EncoderTurnCommand(driveTrain, -180, 0.1);
  }

  public Command getEncoderDriveCommand() {
    return new EncoderDriveCommand(driveTrain, 1, 0.1);
  }

  public Command getSequenceTest01() {
    return new SequentialTest01(driveTrain);
  }

  public Command getAimDriveCommand() {
    return new AimDriveCommand(driveTrain, .25, 3.0);
  }

  public Command getAimTimeCommand(){
    return new AimTimeCommand(driveTrain, .25, 5);
  }
  

}
