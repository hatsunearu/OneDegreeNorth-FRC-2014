/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.IntakeDoNothing;
/**
 *
 * @author Kartikye
 */
public class Intake extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    Relay motor1, motor2;
    
    public Intake(){
        super("Intake");
        motor1 = new Relay(RobotMap.intake1);
        motor2 = new Relay(RobotMap.intake2);
        System.out.println("INTAKE instantiation"); //DEBUG
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new IntakeDoNothing());
    }
    
    public void stop(){
        motor1.set(Relay.Value.kOff);
        motor2.set(Relay.Value.kOff);
        //System.out.println("INTAKE stop"); //DEBUG
    }
    
    public void in(){
        motor1.set(Relay.Value.kForward);
        motor2.set(Relay.Value.kForward);
        //may require reversal
        //System.out.println("INTAKE in"); //DEBUG
    }
    
    public void out(){
        motor1.set(Relay.Value.kReverse);
        motor2.set(Relay.Value.kReverse);
        //may require reversal
        //System.out.println("INTAKE out"); //DEBUG
    }
}
