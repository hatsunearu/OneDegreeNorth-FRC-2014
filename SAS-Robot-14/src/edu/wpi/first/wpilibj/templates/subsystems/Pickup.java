/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.templates.RobotMap;
/**
 *
 * @author Kartikye
 */
public class Pickup extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Victor motor;
    
<<<<<<< HEAD:SAS-Robot-14/src/edu/wpi/first/wpilibj/templates/subsystems/PickerUpper.java
    public PickerUpper(){
        super("PickerUpper");
        motor = new Victor(RobotMap.pickerUpper);
=======
    public Pickup(){
        super("Pickup");
>>>>>>> 52d1b87fd5b6ab682287760220f10f5d04666b96:SAS-Robot-14/src/edu/wpi/first/wpilibj/templates/subsystems/Pickup.java
    }
    
    public void initDefaultCommand() {
        
    }
    
<<<<<<< HEAD:SAS-Robot-14/src/edu/wpi/first/wpilibj/templates/subsystems/PickerUpper.java
    public void doNothing(){
        motor.set(0);
    }
    
    public void in(){
        motor.set(1);
    }
    
    public void out(){
        motor.set(-1);
    }
=======
    
>>>>>>> 52d1b87fd5b6ab682287760220f10f5d04666b96:SAS-Robot-14/src/edu/wpi/first/wpilibj/templates/subsystems/Pickup.java
}
