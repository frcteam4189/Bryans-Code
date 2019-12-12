/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class PanTilt extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Servo m_pan = new Servo(RobotMap.servoPortPan);
  private Servo m_tilt = new Servo(RobotMap.servoPortTilt);

  public void setAngle(double panAngle,double tiltAngle){
    m_pan.setAngle(panAngle);
    m_tilt.setAngle(tiltAngle);
  }

  public double getPanAngle(){
    return m_pan.getAngle();
  }
  public double getTitAngle(){
    return m_tilt.getAngle();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
