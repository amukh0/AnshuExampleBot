package frc.robot.subsystems;

import edu.wpi.first.wpilibj.simulation.DCMotorSim;

public class ShooterSubsytemIOSim implements ShooterSubsystemIO{
    private DCMotorSim shooterMotorSim_ = new DCMotorSim(null, 0, 0);
    


    @Override
    public void updateInputs(ShooterSubsystemIOInputs inputs){
        shooterMotorSim_.update(0.02);
        inputs.shooterVelocity = shooterMotorSim_.getAngularVelocityRPM();
    }


    @Override
    public void setRPS(double rps){
        shooterMotorSim_.setInputVoltage(1);
    }


}
