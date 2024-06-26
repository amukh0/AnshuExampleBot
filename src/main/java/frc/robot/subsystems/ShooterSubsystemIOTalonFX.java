package frc.robot.subsystems;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

public class ShooterSubsystemIOTalonFX implements ShooterSubsystemIO {
    private final TalonFX shooterMotor_ = new TalonFX(3);
    private final StatusSignal<Double> shooterVelocity = shooterMotor_.getVelocity();
    

    public ShooterSubsystemIOTalonFX(){
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

        BaseStatusSignal.setUpdateFrequencyForAll(50.0, shooterVelocity);
        shooterMotor_.optimizeBusUtilization();
    }

    @Override
    public void updateInputs(ShooterSubsystemIOInputs inputs) {
        BaseStatusSignal.refreshAll(shooterVelocity);
    
        inputs.shooterVelocity = shooterVelocity.getValueAsDouble();
    }

    @Override
    public void setRPS(double rps){
        final MotionMagicVelocityVoltage request = new MotionMagicVelocityVoltage(0);
        shooterMotor_.setControl(request.withVelocity(rps));
    }
}