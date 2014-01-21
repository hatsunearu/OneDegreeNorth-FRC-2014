/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotConstants;

/**
 *
 * @author Kartikye
 */
public class DriveWithJoysticks extends CommandBase {
    
    public DriveWithJoysticks() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if( !RobotConstants.linear ) {
            drivetrain.tankDrive( getSign( oi.getLeftStick() ) * Math.sqrt(Math.abs(oi.getLeftStick())), getSign( oi.getRightStick() ) * Math.sqrt(Math.abs(oi.getRightStick())));
        }
        else {
            drivetrain.tankDrive(oi.getLeftStick(), oi.getRightStick());
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private short getSign(double d) {
        if(d >= 0) {
            return -1;
        }
        return 1;
    }
}
