
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * A subsystem that controls the Climber on the robot.
 */
public class Climber extends SubsystemBase {
  private final WPI_TalonFX leftClimberMotor;
  private final WPI_TalonFX rightClimberMotor;

  /**
   * Creates a Climber with its left and right {@link WPI_TalonFX} at the given IDS.
   *
   * @param leftMotorID The ID of the left motor
   * @param rightMotorID The ID of the right motor
   */
  public Climber(int leftMotorID, int rightMotorID) {
    leftClimberMotor = new WPI_TalonFX(leftMotorID);
    rightClimberMotor = new WPI_TalonFX(rightMotorID);
    leftClimberMotor.configSupplyCurrentLimit(
        new SupplyCurrentLimitConfiguration(true, Constants.ClimberConstants.CLIMBER_CURRENT_LIMIT,
            Constants.ClimberConstants.CLIMBER_TRIGGER_THRESHOLD,
            Constants.ClimberConstants.CLIMBER_TRIGGER_THRESHOLD_TIME));
    rightClimberMotor.configSupplyCurrentLimit(
        new SupplyCurrentLimitConfiguration(true, Constants.ClimberConstants.CLIMBER_CURRENT_LIMIT,
            Constants.ClimberConstants.CLIMBER_TRIGGER_THRESHOLD,
            Constants.ClimberConstants.CLIMBER_TRIGGER_THRESHOLD_TIME));
    leftClimberMotor.setNeutralMode(NeutralMode.Brake);
    rightClimberMotor.setNeutralMode(NeutralMode.Brake);
    CommandScheduler.getInstance().registerSubsystem(this);
  }

  /**
   * Set the speed of the left and right Climber motors in PercentOutput.
   *
   * @param speed The speed to set both climbers to
   */
  public void setSpeed(double speed) {
    leftClimberMotor.set(ControlMode.PercentOutput, speed);
    rightClimberMotor.set(ControlMode.PercentOutput, speed);
  }

}
