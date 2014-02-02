/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasrobotics.FRC2014.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Admin
 */
public class InterruptAll extends CommandGroup {
    
    public InterruptAll() {
        addParallel(new LauncherDoNothing());
        addParallel(new IntakeDoNothing());
        addParallel(new DriveWithJoysticks());
    }

}
