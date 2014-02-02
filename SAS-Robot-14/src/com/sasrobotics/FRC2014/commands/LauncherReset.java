/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasrobotics.FRC2014.commands;

import com.sasrobotics.FRC2014.templates.RobotConstants;
import com.sasrobotics.FRC2014.subsystems.Launcher;

/**
 *
 * @author Kartikye
 */
public class LauncherReset extends CommandBase {
    
    double speed = RobotConstants.defaultRetractSpeed;
    
    public LauncherReset() {
        requires(launcher);
        this.setTimeout(RobotConstants.defaultRetractTime);
    }
    
    public LauncherReset(double spd) {
        requires(launcher);
        this.setTimeout(RobotConstants.defaultRetractTime);
        speed = spd;
    }
    
    public LauncherReset(double spd, double timeout) {
        requires(launcher);
        this.setTimeout(RobotConstants.defaultRetractTime);
        speed = spd;
        this.setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        launcher.retract(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (launcher.isRetracted() || this.isTimedOut());
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
