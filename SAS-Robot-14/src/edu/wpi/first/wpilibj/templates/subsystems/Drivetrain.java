/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoysticks;

/**
 *
 * @author Kartikye
 */
public class Drivetrain extends Subsystem {
    
    RobotDrive drive;
    
    public Drivetrain(){
        super("Drivetrain");
        drive = new RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());
    }
    
    public void tankDrive(double left, double right){
        drive.tankDrive(left, right);
    }
    
    public void driveStraight(double speed) {
        if (Math.abs(speed) < 0.3) {
            drive.tankDrive(speed * speed / Math.abs(speed),speed * speed / Math.abs(speed));
        } 
        else if (Math.abs(speed) < 0.1) {
            drive.tankDrive(0, 0);
        } else { 
            drive.tankDrive(speed, speed);
        }
    }
    
}
