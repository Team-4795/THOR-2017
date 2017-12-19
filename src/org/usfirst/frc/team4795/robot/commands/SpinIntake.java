package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;
import org.usfirst.frc.team4795.robot.subsystems.GearArm;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class SpinIntake extends Command {
	
	public float speed;
	
	public SpinIntake(float speed) {
		requires(Robot.geararm);
		this.speed = speed;
	}

	@Override
	protected void initialize() {
		Robot.geararm.spinWheel(speed);
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.geararm.spinWheel(0);
	}

	@Override
	protected void interrupted() {
		end();
	}


}
