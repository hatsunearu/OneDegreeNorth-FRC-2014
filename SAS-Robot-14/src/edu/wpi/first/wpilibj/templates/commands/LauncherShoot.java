/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotConstants;
import edu.wpi.first.wpilibj.templates.subsystems.Launcher;

public class LauncherShoot extends CommandBase {
    
    double strength = 0.9;
    Launcher launch = new Launcher();
    
    public LauncherShoot() {
        requires(launcher);
        this.setTimeout(RobotConstants.defaultLaunchTime);
    }
    
    public LauncherShoot(double s) {
        requires(launcher);
        this.setTimeout(RobotConstants.defaultLaunchTime);
    }
    
    public LauncherShoot(double s, double t) {
        requires(launcher);
        strength = s;
        this.setTimeout(t);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        launch.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        launch.move(strength);
    }

    protected boolean isFinished() { //safety mechanism, robot should stop moving when timeout is reached
        return launch.isLaunched();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
