// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final TalonFX shooterMotor_ = new TalonFX(3);



  public ShooterSubsystem() {
  var talonFXConfigs = new TalonFXConfiguration();

   
    var slot0Configs = talonFXConfigs.Slot0;
    slot0Configs.kS = 0; 
    slot0Configs.kV = 0.12; 
    slot0Configs.kA = 0.01; 
    slot0Configs.kP = 0; 
    slot0Configs.kI = 0; 
    slot0Configs.kD = 0; 

    
    var motionMagicConfigs = talonFXConfigs.MotionMagic;
    motionMagicConfigs.MotionMagicCruiseVelocity = 20; 

    shooterMotor_.getConfigurator().apply(talonFXConfigs);
    
  }
  public TalonFX getMotor(){
    return shooterMotor_;

  }

  /**
   * Example command factory method.
   *
   * @return a command 
   */
  public StatusCode SetRPS(double rps){
    final MotionMagicVelocityVoltage request_ = new MotionMagicVelocityVoltage(0);
          final TalonFX shooterMotor_ = this.getMotor(); // initialize motor
          return shooterMotor_.setControl(request_.withVelocity(rps));
  }
  
  public Command ShootCommand(double rps) {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.

    return runOnce(
        () -> {
          /* one-time action goes here */
          this.SetRPS(rps);
        });
  }





  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
