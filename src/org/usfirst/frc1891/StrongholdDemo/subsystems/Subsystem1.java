// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1891.StrongholdDemo.subsystems;

import org.usfirst.frc1891.StrongholdDemo.RobotMap;
import org.usfirst.frc1891.StrongholdDemo.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Subsystem1 extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon rightSlave = RobotMap.subsystem1RightSlave;
    private final CANTalon leftSlave = RobotMap.subsystem1LeftSlave;
    private final CANTalon leftMaster = RobotMap.subsystem1LeftMaster;
    private final CANTalon rightMaster = RobotMap.subsystem1RightMaster;
    private final RobotDrive chassis = RobotMap.chassis;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	this.setDefaultCommand(new JoyDrive());
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void stop()
    {
    	leftMaster.set(0);
    	rightMaster.set(0);
    }
    
    public void joyDrive(Joystick leftJoy, Joystick rightJoy)
    {
    	rightMaster.set(deadBand(leftJoy.getY(), 0.1));
    	leftMaster.set(deadBand(rightJoy.getY(), 0.1));
    }
    
 // Creates an area on joystick where no value is registered. Prevents controller touchiness.
    private double deadBand(double axisVal, double deadBand)
	{
		if(axisVal < -deadBand)
			return axisVal;
		if(axisVal > +deadBand)
			return axisVal;
		return 0;
	}
    
    // lowers value of input to decrease fast acceleration when deadband is exited.
    private double indexInput(double axisVal, double index)
    {
    	if (axisVal > 0)
    	{
    		axisVal = axisVal - index;
    	}
    	else if (axisVal < 0)
    	{
    		axisVal = axisVal + index;
    	}
    	return axisVal;
    }
    
    /**
     * Sets motor output value for front left motor. Different control modes apply the value differently
     * 
     * 	percentage mode - sets percent of power to be applied.
     * 	voltage mode - sets voltage to be applied.
     * 	velocity mode - sets target velocity for PID closed loop.
     * 	position mode - sets target position for PID closed loop.
     * 
     * @param value 
     */
    public void setFrontLeftWheel(double value)
    {
    	leftMaster.set(value);
    }
    
    /**
     * Sets motor output value for front right motor. Different control modes apply the value differently
     * 
     * 	percentage mode - sets percent of power to be applied.
     * 	voltage mode - sets voltage to be applied.
     * 	velocity mode - sets target velocity for PID closed loop.
     * 	position mode - sets target position for PID closed loop.
     * 
     * @param value 
     */
    public void setFrontRightWheel(double value)
    {
    	rightMaster.set(value);
    }
}

