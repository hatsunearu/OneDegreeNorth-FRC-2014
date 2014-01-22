/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Vision extends Subsystem {
    
    double distance;
    
    public Vision() {
        super("vision");
    }

    public void initDefaultCommand() {
        getDistance();
    }
    
    public double getDistance(){
        distance = SmartDashboard.getNumber("Distance");
        return distance;
    }
    
    
    
}
