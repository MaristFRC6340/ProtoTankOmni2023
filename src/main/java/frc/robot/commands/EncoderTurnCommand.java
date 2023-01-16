// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class EncoderTurnCommand extends CommandBase {
  //fields
  private double angleDegrees;
  private double power;
  private double target;
  private double error;
  private double kP = 0.05;

  private DriveTrain drivetrain;
  private RelativeEncoder leftEncoder;
  private RelativeEncoder rightEncoder;

  public EncoderTurnCommand (DriveTrain dtrain, double turnDegs, double pwr)
  {
      drivetrain = dtrain;
      angleDegrees = turnDegs;
      power = pwr;

      leftEncoder = drivetrain.getLeftEnc();
      rightEncoder = drivetrain.getRightEnc();

      addRequirements(drivetrain);

      drivetrain.setBrakeMode();
  }

  public void initialize()
  {
      leftEncoder.setPosition(0);
      rightEncoder.setPosition(0);
      error = 0;

      target = angleDegrees * (11.0/90); // Conversion Temp Ratio 

      drivetrain.setBrakeMode();
  }

  public void execute()
  {
      error = target - leftEncoder.getPosition();
      System.out.println("Error: " + error);
      double turnAdjust = error * kP;
      if (turnAdjust > power) {
          turnAdjust = power;
      }
      if (turnAdjust < -power) {
          turnAdjust = -power;
      }

      drivetrain.drive(-turnAdjust, turnAdjust);

  }

  public void end(boolean interrupted)
  {
    drivetrain.drive(0,0);
    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);

  }

  public boolean isFinished() {
      double currentAngle = leftEncoder.getPosition();

      //double currentAngle = 0;

      //if(target > 0 && currentAngle > target)
      //{
      //    return true;
      //}
      //if(target < 0 && currentAngle < target)
      //{
      //    return true;
      //}

      if (Math.abs(error) < 0.1) {
          return true;
      }

      //System.out.println(target + ", " + currentAngle);
      return false;
  }
  
}
