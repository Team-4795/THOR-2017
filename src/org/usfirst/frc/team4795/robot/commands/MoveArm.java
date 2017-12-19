package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;
import org.usfirst.frc.team4795.robot.subsystems.GearArm;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveArm extends Command {

	
	public MoveArm() {
		requires(Robot.geararm);
	}

	@Override
	protected void initialize() {
		Robot.geararm.changeControlMode(TalonControlMode.PercentVbus);
	}

	@Override
	protected void execute() {
		double throttle = (1.0 - Robot.oi.ARM_JOY.getThrottle()) / -2.0;
		Robot.geararm.setRaw(Robot.oi.getAttackJoyY() * throttle);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		end();
	}

}
