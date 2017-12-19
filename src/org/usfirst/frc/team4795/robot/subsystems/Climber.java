package org.usfirst.frc.team4795.robot.subsystems;

import org.usfirst.frc.team4795.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

	protected VictorSP motor;

	public Climber() {
		motor = new VictorSP(RobotMap.CLIMBER_MOTOR.value);
	}
	
	public void setRaw(double speed)
	{
		motor.set(speed);
	}
	
	@Override
	protected void initDefaultCommand() {

	}

}
