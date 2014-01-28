/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

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
    public static final double defaultLaunchTime = 0.5;
    public static final double defaultLaunchSpeed = 1.0;

    //LauncherReset
    public static final double defaultRetractTime = 1;
    public static final double defaultRetractSpeed = 0.5;
    
    //Default Drive Distance
    public static final double DriveDistance = pref.getDouble("DriveDistanceKp", 3);
    public static final double DriveDistanceKp = pref.getDouble("DriveDistanceKp", .44);
    public static final double DriveDistanceKi = pref.getDouble("DriveDistanceKp", 0.00133);
    public static final double DriveDistanceSpeedLimit = pref.getDouble("DriveDistanceKp", .6);
    public static final double DriveDistanceTimeout = pref.getDouble("DriveDistanceKp", 10);
}
