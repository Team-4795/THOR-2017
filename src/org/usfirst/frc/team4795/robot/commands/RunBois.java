package org.usfirst.frc.team4795.robot.commands;

import org.usfirst.frc.team4795.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RunBois extends Command {

	private final double speed;

	public RunBois(double time, double speed) {
		requires(Robot.drivetrain);
		this.setTimeout(time);
		this.speed = speed;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.drivetrain.setRaw(speed * 1.5f, speed);
	}

	@Override
	protected boolean isFinished() {
		return this.isTimedOut();
	}

	@Override
	protected void end() {
		Robot.drivetrain.setRaw(0.0, 0.0);
		Timer.delay(5);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
