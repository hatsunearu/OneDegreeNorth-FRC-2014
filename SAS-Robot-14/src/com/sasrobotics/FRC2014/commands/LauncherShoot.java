/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasrobotics.FRC2014.commands;

import com.sasrobotics.FRC2014.templates.RobotConstants;
import com.sasrobotics.FRC2014.subsystems.Launcher;

public class LauncherShoot extends CommandBase {
    
    double speed = RobotConstants.defaultLaunchSpeed;
    double currSpeed = 0;
    
    public LauncherShoot() {
        requires(launcher);
        this.setTimeout(RobotConstants.defaultLaunchTime);
    }
    
    public LauncherShoot(double spd) {
        requires(launcher);
        speed = spd;
        this.setTimeout(RobotConstants.defaultLaunchTime);
    }
    
    public LauncherShoot(double spd, double timeout) {
        requires(launcher);
        speed = spd;
        this.setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        launcher.stop();
        currSpeed = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(currSpeed < speed) {
            currSpeed += 0.05;
        }
        launcher.move(currSpeed);
    }

    protected boolean isFinished() { //safety mechanism, robot should stop moving when timeout is reached
        return (launcher.isLaunched() || this.isTimedOut());
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
