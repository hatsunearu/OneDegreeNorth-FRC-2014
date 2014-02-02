/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasrobotics.FRC2014.commands;

import com.sasrobotics.FRC2014.subsystems.Intake;

/**
 *
 * @author hatsunearu
 */
public class IntakeIn extends CommandBase {
    
    public IntakeIn() {
        requires(intake);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        intake.in();
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
    
}
