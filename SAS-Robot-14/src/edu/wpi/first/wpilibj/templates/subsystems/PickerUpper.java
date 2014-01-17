/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.PickerUpperDoNothing;
/**
 *
 * @author Kartikye
 */
public class PickerUpper extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    Victor motor;
    
    public PickerUpper(){
        super("PickerUpper");
        motor = new Victor(RobotMap.pickerUpper);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new PickerUpperDoNothing());
    }
    
    public void doNothing(){
        motor.set(0);
    }
    
    public void in(){
        motor.set(1);
    }
    
    public void out(){
        motor.set(-1);
    }
}
