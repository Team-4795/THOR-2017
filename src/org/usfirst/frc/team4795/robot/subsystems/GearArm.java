package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;
import org.usfirst.frc.team4795.robot.commands.MoveArm;
import org.usfirst.frc.team4795.robot.commands.TankDrive;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearArm extends Subsystem {

	public static final int ENCODER_TICKS_PER_REV = 497;

	public static double P = 1;
	public static double I = 0.01;
	public static double D = 10.0;
	public static double F = 1;

	CANTalon armLever;
	VictorSP spinMotor;

	public GearArm() {
		armLever = new CANTalon(RobotMap.ARM_MOTOR.value);
		armLever.disableControl();
		armLever.configEncoderCodesPerRev(ENCODER_TICKS_PER_REV);
		armLever.configMaxOutputVoltage(12);
		armLever.ConfigFwdLimitSwitchNormallyOpen(true);
		armLever.ConfigRevLimitSwitchNormallyOpen(true);
		armLever.enableLimitSwitch(true, true);
		armLever.enableBrakeMode(true);
		armLever.setVoltageRampRate(24.0);
		armLever.enableControl();
		spinMotor = new VictorSP(RobotMap.ARM_SPIN_MOTOR.value);
	}

	public void setPID(double P, double I, double D) {
		armLever.setPID(P, I, D);
	}

	public void setPID(double P, double I, double D, double F) {
		setPID(P, I, D);
		armLever.setF(F);
	}

	public void setRampRate(double rampRate) {
		armLever.setVoltageRampRate(rampRate);
	}

	public void zeroPos() {
		armLever.setEncPosition(0);
	}

	public double getPosRaw() {
		return armLever.getPosition();
	}

	public double getPosDegrees() {
		return getPosRaw() * 360.0;
	}

	public void setPosDegrees(double angle, double P, double I, double D) {
		setPosRaw(angle / 360.0, P, I, D);
	}

	public void setPosRaw(double angle, double P, double I, double D) {
		changeControlMode(TalonControlMode.Position);
		setPID(P, I, D);
		armLever.set(angle);
	}

	public void changeControlMode(TalonControlMode mode) {
		armLever.changeControlMode(mode);
	}

	public void setRaw(double value) {
		armLever.set(value);
	}

	public void spinWheel(double speed) {
		spinMotor.set(speed);
	}

	public boolean getForwardLimit() {
		return armLever.isFwdLimitSwitchClosed();
	}

	public boolean getReverseLimit() {
		return armLever.isRevLimitSwitchClosed();
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MoveArm());
	}

}
