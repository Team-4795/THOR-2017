package org.usfirst.frc.team4795.robot;

import org.usfirst.frc.team4795.robot.commands.RunBois;
import org.usfirst.frc.team4795.robot.subsystems.Climber;
import org.usfirst.frc.team4795.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4795.robot.subsystems.GearArm;


import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;

	public static Drivetrain drivetrain;
	public static GearArm geararm;
	public static Climber climber;
	
	public static DigitalInput limitSwitch;
	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		drivetrain = new Drivetrain();
		geararm = new GearArm();
		climber = new Climber();
		limitSwitch = new DigitalInput(RobotMap.BACK_LIMITSWITCH.value);
		oi = new OI();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		Scheduler.getInstance().add(new RunBois(2.5, 0.6));
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.getNumber("P",GearArm.P);
		SmartDashboard.getNumber("I",GearArm.I);
		SmartDashboard.getNumber("D",GearArm.D);
		SmartDashboard.getNumber("F",GearArm.F);
		/*
		if(limitSwitch.get() == true)
		{
			geararm.changeControlMode(TalonControlMode.PercentVbus);
			geararm.setRaw(0);
		}
		*/
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
