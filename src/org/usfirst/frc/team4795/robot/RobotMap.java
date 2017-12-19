package org.usfirst.frc.team4795.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public enum RobotMap {
	// PWM Motor mappings
	LEFT_MOTOR(0), RIGHT_MOTOR(7),CLIMBER_MOTOR(2),ARM_SPIN_MOTOR(3),
	// CAN Motor mappings
	ARM_MOTOR(0),
	//
	BACK_LIMITSWITCH(0),
	// Joystick mappings
	LEFT_JOY(0), RIGHT_JOY(1), ARM_JOY(2) ,ARM_UP(5), ARM_DOWN(3),SPIN_INTAKE(3),SPIN_INTAKE_BACK(2),SPIN_CLIMBER(3);

	public final int value;

	RobotMap(int value) {
		this.value = value;
	}
}
