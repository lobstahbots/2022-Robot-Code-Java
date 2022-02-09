
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
  private final WPI_TalonFX climberMotor;

  /**
   * Creates a Climber with its {@link WPI_TalonFX} at the given id.
   * 
   * @param motorId The motor ID of the motor
   */
  public Climber(int motorId) {
    climberMotor = new WPI_TalonFX(motorId);
    climberMotor.setNeutralMode(NeutralMode.Brake);
    CommandScheduler.getInstance().registerSubsystem(this);
  }

  /**
   * Set the speed of the Climber motor in PercentOutput
   * 
   * @param speed
   */
  public void setSpeed(double speed) {
    climberMotor.set(ControlMode.PercentOutput, speed);
  }

}
