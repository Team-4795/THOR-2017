package org.usfirst.frc.team4795.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public enum RobotMap 
{
    // Motor mappings
    LEFT_MOTOR(0),	
    RIGHT_MOTOR(1),
    // Joystick mappings
    LEFT_JOY(0),
    RIGHT_JOY(1);
    
    public final int value;

    RobotMap(int value) {
        this.value = value;
    }
}
