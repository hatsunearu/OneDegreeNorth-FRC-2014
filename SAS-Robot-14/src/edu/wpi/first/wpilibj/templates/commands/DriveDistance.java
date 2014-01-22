package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotConstants;

/**
 *
 * @author Samsung
 */
public class DriveDistance extends CommandBase {
    
    private boolean stopped = false;
    double distanceToDrive = RobotConstants.DriveDistance;
    double Kp = RobotConstants.DriveDistanceKp;
    double error;
    
    public DriveDistance() {
        requires(drivetrain);
        requires(vision);
        this.setTimeout(RobotConstants.DriveDistanceTimeout);
    }
    
    public DriveDistance(double distance) {
        distanceToDrive = distance;
        requires(drivetrain);
        requires(vision);
        this.setTimeout(RobotConstants.DriveDistanceTimeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        updatePID();
    }

    protected void execute() {
        updatePID();
        drivetrain.tankDrive(Kp * error, Kp * error); 
        System.out.println("Error: " +error+ "Motor: " + Kp * error);
    }
    
    protected void updatePID() {
         error = (vision.getDistance() - distanceToDrive);
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut() || (Math.abs(error) < 0.05);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
