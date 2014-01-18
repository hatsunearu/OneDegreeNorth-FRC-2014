/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Vision extends Subsystem {
    
    public NetworkTable table;
    double distance;
    
    public Vision() {
        super("vision");
    }

    public void initDefaultCommand() {
        table = NetworkTable.getTable("datatable"); 
        getDistance();
    }
    
    public double getDistance(){
        distance = table.getNumber("distance", 0.0);
        System.out.println(distance); //debug statement
        return distance;
    }
    
    
}
