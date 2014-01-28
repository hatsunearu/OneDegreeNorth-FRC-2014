package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Preferences;

/**
 *
 * @author Samsung
 */
public class DriveDistance extends CommandBase {
    
    Preferences prefs = Preferences.getInstance();
    
    double distanceToDrive;
    double Kp;
    double Ki;
    double speedLimit;
    double error, errorSum = 0;
    
    public DriveDistance() {
        requires(drivetrain);
        requires(vision);
        
        errorSum = 0;
        System.out.println("DriveDistance Instantiation");
    }
    
    public DriveDistance(double distance) {
        distanceToDrive = distance;
        requires(drivetrain);
        requires(vision);
        
        errorSum = 0;
        System.out.println("DriveDistance Instantiation");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        errorSum = 0;
        
        Kp = prefs.getDouble("DriveDistanceKp", 0.75);
        Ki = prefs.getDouble("DriveDistanceKi", 0);
        this.setTimeout(prefs.getDouble("DriveDistanceTO", 5));
        speedLimit = prefs.getDouble("DriveDistanceSL", 0.55);
        distanceToDrive = prefs.getDouble("DriveDistanceTarget", 3);
        
        System.out.println("Kp = "+Kp+" Ki = "+Ki);
        updatePID();
    }

    protected void execute() {
        updatePID();
        filterMove(Kp * error + Ki * errorSum);
        System.out.println("Prop term: " + Kp * error + " Integral Term: " + Ki * errorSum);
    }
    
    protected void updatePID() {
         if (Math.abs(error) < 10) { //reject unusual errors
            error = (vision.getDistance() - distanceToDrive);
         }
         errorSum += error;
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }
    
    protected void filterMove(double speed) {
        if (Math.abs(speed) > speedLimit) {
            speed = (speedLimit * getSign(speed));
        }
        drivetrain.driveStraight(speed); 
        System.out.println("Speed: " + speed);
    }
    
    protected short getSign(double n) {
        if (n < 0) {
            return -1;
        }
        return 1;
    }

    // Called once after isFinished returns true
    protected void end() {
        error = 0;
        drivetrain.driveStraight((0));
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        error=0;
    }
}
