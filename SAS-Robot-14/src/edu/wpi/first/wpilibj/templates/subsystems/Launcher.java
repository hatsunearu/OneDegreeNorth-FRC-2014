/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
//import digital IO

public class Launcher extends Subsystem {

    Victor motor;
    boolean lowLimSwitch = false;
    boolean highLimSwitch = false;
    
    final boolean retractSpeed = -0.5; 
    
    public Launcher(){
        super("Launcher");
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new LauncherDoNothing());
    }
    
    public void move(double speed) {
        
        if(!highLimSwitch && speed >= 0 && speed <= 1) {
            motor.set(speed);
        }
        else {
            motor.stop();
        }
        
    }
    
    public void retract(){
        if(!lowLimSwitch) {
            motor.set(retractSpeed);
        }
        else {
            motor.stop();
        }
    }
    
    public void stop() {
        motor.set(0);
    }
    
    public void updateSwitches() {
        //update lowLimSwitch highLimSwitch
    }
}
