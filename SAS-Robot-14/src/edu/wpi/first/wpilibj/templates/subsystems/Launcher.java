/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
/**
 *
 * @author Kartikye
 */
public class Launcher extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Victor motor;
    
    public Launcher(){
        super("Launcher");
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void in() {
        motor.set(1);
    }
    
    public void out(){
        motor.set(-1);
    }
    
    public void stop() {
        motor.set(0);
    }
}
