/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
/**
 *
 * @author Kartikye
 */
public class NetworkTables extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    NetworkTable table;
    double distance;
    
    public NetworkTables(){
        super("networkTables");
    }

    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        table = NetworkTable.getTable("datatable"); 
        
    }
    
    public double getDistance(){
        distance = table.getNumber("distance",0.0);
        System.out.println(distance);
        return distance;
    }
    
    
}
