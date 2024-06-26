package frc.robot.subsystems;

import org.littletonrobotics.junction.AutoLog;


public interface ShooterSubsystemIO{
    @AutoLog
    public static class ShooterSubsystemIOInputs{
        public double shooterVelocity = 0;
        
    }

    public default void updateInputs(ShooterSubsystemIOInputs inputs){}

    public default void setRPS(double rps){}
}


  