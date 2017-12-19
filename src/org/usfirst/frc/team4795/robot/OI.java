package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.*;
import org.usfirst.frc.team4795.robot.subsystems.Climber;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class OI {
	public static final double JOY_DEADZONE = 0.05;

	public final Joystick LEFT_JOY = new Joystick(RobotMap.LEFT_JOY.value);
	public final Joystick RIGHT_JOY = new Joystick(RobotMap.RIGHT_JOY.value);
	public final Joystick ARM_JOY = new Joystick(RobotMap.ARM_JOY.value);
	
	public JoystickButton ARM_UP = new JoystickButton(RIGHT_JOY, RobotMap.ARM_UP.value);
	public JoystickButton ARM_DOWN = new JoystickButton(RIGHT_JOY, RobotMap.ARM_DOWN.value);
	public JoystickButton SPIN = new JoystickButton(ARM_JOY, RobotMap.SPIN_INTAKE.value);
	public JoystickButton SPIN_BACK = new JoystickButton(ARM_JOY,RobotMap.SPIN_INTAKE_BACK.value);
	public JoystickButton CLIMB = new JoystickButton(LEFT_JOY, RobotMap.SPIN_CLIMBER.value);
	
	public double getLeftJoyX() {
		double raw = LEFT_JOY.getX();
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}

	public double getLeftJoyY() {
		double raw = LEFT_JOY.getY();
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}

	public double getRightJoyX() {
		double raw = RIGHT_JOY.getX();
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}

	public double getRightJoyY() {
		double raw = RIGHT_JOY.getY();
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}
	
	public double getAttackJoyX() {
		double raw = ARM_JOY.getX();
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}

	public double getAttackJoyY() {
		double raw = ARM_JOY.getY();
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}
	
	public OI()
	{
    	Command cmdSpin = new SpinIntake(0.4f);
    	Command cmdSpinBack = new SpinIntake(-0.4f);
    	
    	Command cmbClimb = new SpinClimber(-1f);
    	Command cmdStopClimb = new SpinClimber(0);
    	    	
    	SPIN.whileHeld(cmdSpin);
    	SPIN_BACK.whileHeld(cmdSpinBack);
    	
    	CLIMB.whenPressed(cmbClimb);
    	CLIMB.whenReleased(cmdStopClimb);
	}
}
