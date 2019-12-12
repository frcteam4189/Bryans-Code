/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoysticks;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Talon m_leftBack = new Talon(RobotMap.leftMotorPort);
  private Talon m_leftFront = new Talon(RobotMap.leftMotor2Port);
  private Talon m_rightBack = new Talon(RobotMap.rightMotorPort);
  private Talon m_rightFront = new Talon(RobotMap.rightMotor2Port);

  private SpeedControllerGroup m_leftGroup = new SpeedControllerGroup(m_leftBack, m_leftFront);
  private SpeedControllerGroup m_rightGroup = new SpeedControllerGroup(m_rightBack, m_rightFront);

  private DifferentialDrive m_drive = new DifferentialDrive(m_leftGroup, m_rightGroup);

  public void drive(double x, double y){
    m_drive.tankDrive(x, y);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveWithJoysticks());
  }
}
