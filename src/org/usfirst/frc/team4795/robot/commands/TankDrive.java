package org.usfirst.frc.team4795.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4795.robot.Robot;

public class TankDrive extends Command {

	public TankDrive() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
	}

	protected void execute() {
		double throttle = (1.0 - Robot.oi.LEFT_JOY.getThrottle()) / -2.0;
		Robot.drivetrain.setRaw(Robot.oi.getLeftJoyY() * throttle,
				Robot.oi.getRightJoyY() * throttle);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void interrupted() {
		end();
	}

}
