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
    
    Launcher launch = new Launcher();
    
    public LauncherReset() {
        requires(launcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        launch.retract();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return launch.isRetracted();
    }

    // Called once after isFinished returns true
    protected void end() {
        launch.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
