/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Admin
 */
public class LauncherShootAndReset extends CommandGroup {
    public LauncherShootAndReset() {
        addSequential(new LauncherShoot());
        addSequential(new LauncherReset());
    }
}
