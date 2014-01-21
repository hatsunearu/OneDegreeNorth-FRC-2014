/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Launcher;

/**
 *
 * @author Kartikye
 */
public class LauncherReset extends CommandBase {
    
    public LauncherReset() {
        requires(launcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        launcher.retract();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return launcher.isRetracted();
    }

    // Called once after isFinished returns true
    protected void end() {
        launcher.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
