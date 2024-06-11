// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class ShootCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShooterSubsystem subsystem_;
  private final double rps_;
  


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   *  
   */
  public ShootCommand(ShooterSubsystem subsystem, double rps){
    subsystem_ = subsystem;
    rps_ = rps;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem_);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    subsystem_.ShootCommand(rps_);
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){} 
  
 

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    subsystem_.ShootCommand(0);

  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return false;
  }
}
