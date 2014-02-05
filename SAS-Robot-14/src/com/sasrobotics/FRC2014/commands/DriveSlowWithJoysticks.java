/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasrobotics.FRC2014.commands;

import com.sasrobotics.FRC2014.templates.RobotConstants;

/**
 *
 * @author Admin
 */
public class DriveSlowWithJoysticks extends CommandBase {
    
     public DriveSlowWithJoysticks() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if( !RobotConstants.linear ) {
            drivetrain.tankDrive( 0.5 * getSign( oi.getLeftStick() ) * Math.sqrt(Math.abs(oi.getLeftStick())), 0.5 * getSign( oi.getRightStick() ) * Math.sqrt(Math.abs(oi.getRightStick())));
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
