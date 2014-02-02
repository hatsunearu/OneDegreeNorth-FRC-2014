/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasrobotics.FRC2014.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import com.sasrobotics.FRC2014.commands.LauncherDoNothing;
import com.sasrobotics.FRC2014.templates.RobotConstants;
import com.sasrobotics.FRC2014.templates.RobotMap;
//import digital IO

public class Launcher extends Subsystem {

    Victor motor = new Victor(RobotMap.launcher);
    DigitalInput lower = new DigitalInput(RobotMap.lowerLimitSwitch);
    DigitalInput upper = new DigitalInput(RobotMap.upperLimitSwitch);
    

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
    
    public void retract(double speed){
        
        if(!lowLimSwitch && speed >= 0 && speed <= 1) {
            motor.set(-speed);
        }
        else {
            stop();
        }
        System.out.println("LAUNCHER retract speed:"+speed); //DEBUG
    }
    
    
    public void stop() {
        motor.set(0);
        //System.out.println("LAUNCHER stop"); //DEBUG
    }
    
    public boolean isLaunched() {
        //updateSwitches();
        return highLimSwitch;
    }
    
    public boolean isRetracted() {
        //updateSwitches();
        return lowLimSwitch;
    }
    
    public void updateSwitches() {
        boolean lowLimSwitch = lower.get();
        boolean highLimSwitch = upper.get();
    }
}
