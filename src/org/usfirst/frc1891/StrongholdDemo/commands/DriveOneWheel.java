package org.usfirst.frc1891.StrongholdDemo.commands;

import org.usfirst.frc1891.StrongholdDemo.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveOneWheel extends Command {

	
	private int wheel;
	private static final double power = 100;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveOneWheel(int wheel) {
    	requires(Robot.subsystem1);
    	this.wheel = wheel;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//    	Robot.driveSystem.setPercentageMode();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Nintendo
    	switch(wheel)
    	{
    	case 0:
    		Robot.subsystem1.setFrontLeftWheel(power);
    		break;
    	case 2:
    		Robot.subsystem1.setFrontRightWheel(power);
    		break;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.subsystem1.stop();
//    	Robot.driveSystem.setAllSetPoints(0);
    }
    
    protected void interrupted()
    {
    	end();
    }
}
