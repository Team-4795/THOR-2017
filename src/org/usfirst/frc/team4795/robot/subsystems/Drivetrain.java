package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;
import org.usfirst.frc.team4795.robot.commands.*;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain extends Subsystem {

	private Jaguar LeftMotor;
	private Spark RightMotor;

	public Drivetrain() {
		LeftMotor = new Jaguar(RobotMap.LEFT_MOTOR.value);
		RightMotor = new Spark(RobotMap.RIGHT_MOTOR.value);
	}

	public void setRaw(double leftvalue, double rightvalue) {
		LeftMotor.set(-leftvalue);
		RightMotor.set(rightvalue);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
	}

}
