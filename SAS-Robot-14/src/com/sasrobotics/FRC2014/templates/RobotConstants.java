/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasrobotics.FRC2014.templates;

import edu.wpi.first.wpilibj.Preferences;

/**
 *
 * @author hatsunearu
 * Class containing various constants so it's easy to modify
 */
public class RobotConstants {
    
    static Preferences pref;
    
    //LauncherReset
    public static final double retractTime = 0.5;
    public static final double retractSpeed = 0.3;
    
    //JoystickDrive
    public static final boolean linear = false; //Flag, linear joystick drive
    
    //LauncherShoot
    public static final double defaultLaunchTime = pref.getDouble("defaultLaunchTime", .5);
    public static final double defaultLaunchSpeed = pref.getDouble("defaultLaunchSpeed", .5);

    //LauncherReset
    public static final double defaultRetractTime = 2;
    public static final double defaultRetractSpeed = 0.3;
    
}
