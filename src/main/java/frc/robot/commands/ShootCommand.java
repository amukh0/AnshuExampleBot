// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;

import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class ShootCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShooterSubsystem m_subsystem;
  private final double m_time;
  private Timer m_timer = new Timer();


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   *  
   */
  public ShootCommand(ShooterSubsystem subsystem , double rps, double time){
    m_subsystem = subsystem;
    m_time = time;
    final MotionMagicVelocityVoltage m_request = new MotionMagicVelocityVoltage(0);
    final TalonFX m_shooterMotor = m_subsystem.getMotor(); // initialize motor
    m_shooterMotor.setControl(m_request.withVelocity(rps));

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_subsystem.ShootCommand(20);
    m_timer.start();
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){} 
  
 

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.ShootCommand(0);

  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (m_timer.get() >= m_time){
      return true;
    }
    return false;
  }
}
