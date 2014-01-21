/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.templates.commands.LauncherDoNothing;
import edu.wpi.first.wpilibj.templates.RobotConstants;
import edu.wpi.first.wpilibj.templates.RobotMap;
//import digital IO

public class Launcher extends Subsystem {

    Victor motor = new Victor(RobotMap.launcher);
    boolean lowLimSwitch = false;
    boolean highLimSwitch = false;
    
    public Launcher(){
        super("Launcher");
        System.out.println("LAUNCHER instantiation"); //DEBUG
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new LauncherDoNothing());
    }
    
    public void move(double speed) { 
        
        if(!highLimSwitch && speed >= 0 && speed <= 1) {
            motor.set(speed);
        }
        else {
            stop();
        }
        
        System.out.println("LAUNCHER move speed:" + speed); //DEBUG
        
    }
    
    public void retract(){
        if(!lowLimSwitch) {
            motor.set(- RobotConstants.retractSpeed);
        }
        else {
            stop();
        }
        System.out.println("LAUNCHER retract"); //DEBUG
    }
    
    
    public void stop() {
        motor.set(0);
        System.out.println("LAUNCHER stop"); //DEBUG
    }
    
    public boolean isLaunched() {
        return highLimSwitch;
    }
    
    public boolean isRetracted() {
        return lowLimSwitch;
    }
    
    public void updateSwitches() {
        //update lowLimSwitch highLimSwitch
    }
}
