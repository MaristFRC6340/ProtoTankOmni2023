// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */

  //Spark Motor Controllers for drive Motors 
  private CANSparkMax leftFront;
  private CANSparkMax leftRear;
  private CANSparkMax rightFront;
  private CANSparkMax rightRear;

  // Encoders
  private RelativeEncoder m_LeftEncoder;
  private RelativeEncoder m_RightEncoder;

  public DriveTrain() {
    //Initialize Motor Controllers
    leftFront = new CANSparkMax(13, MotorType.kBrushless);
    leftRear = new CANSparkMax(5, MotorType.kBrushless);
    rightFront = new CANSparkMax(4, MotorType.kBrushless);
    rightRear = new CANSparkMax(12, MotorType.kBrushless);

    // Initialize the Encoders
    m_LeftEncoder = leftFront.getEncoder();
    m_RightEncoder = rightFront.getEncoder();

    // Set Idle Mode Coast by Default
    leftFront.setIdleMode(CANSparkMax.IdleMode.kCoast);
    leftRear.setIdleMode(CANSparkMax.IdleMode.kCoast);
    rightFront.setIdleMode(CANSparkMax.IdleMode.kCoast);
    rightRear.setIdleMode(CANSparkMax.IdleMode.kCoast);

    // Reset Encoders on Initialization
    m_LeftEncoder.setPosition(0);
    m_RightEncoder.setPosition(0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double leftPower, double rightPower) {

    leftFront.set(-leftPower);
    leftRear.set(-leftPower);
    rightFront.set(rightPower);
    rightRear.set(rightPower);
  }

  public void setCoastMode() {
    leftFront.setIdleMode(CANSparkMax.IdleMode.kCoast);
    leftRear.setIdleMode(CANSparkMax.IdleMode.kCoast);
    rightFront.setIdleMode(CANSparkMax.IdleMode.kCoast);
    rightRear.setIdleMode(CANSparkMax.IdleMode.kCoast);
  }

  public void setBrakeMode() {
    leftFront.setIdleMode(CANSparkMax.IdleMode.kBrake);
    leftRear.setIdleMode(CANSparkMax.IdleMode.kBrake);
    rightFront.setIdleMode(CANSparkMax.IdleMode.kBrake);
    rightRear.setIdleMode(CANSparkMax.IdleMode.kBrake);
  }

  // Accessors for the Encoder Drive Commands
  public RelativeEncoder getLeftEnc() {
    return m_LeftEncoder;
  }

  public RelativeEncoder getRightEnc() {
    return m_RightEncoder;
  }


}
