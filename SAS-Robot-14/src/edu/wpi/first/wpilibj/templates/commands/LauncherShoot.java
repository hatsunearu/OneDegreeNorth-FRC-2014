/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.*;

/**
 *
 * @author Kartikye + hatsunearu
 */
public class LauncherShoot extends CommandBase {
    
    int strength = 100; //Strength of throw, 0-100
    int angle = 50; //Launch angle, 0-100
    
    public LauncherShoot() {
        requires(launcher);
    }
    
    public LauncherShoot(int s) {
        requires(launcher);
        strength = s;
    }
    
    public LauncherShoot(int s, int a) {
        requires(launcher);
        strength = s;
        angle = a;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    //return true when angle is reached
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
