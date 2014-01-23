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
    double Kd = RobotConstants.DriveDistanceKd;
    double error;
    double prevError;
    double deltaError;
    long prevTime;
    
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
        error = (vision.getDistance() - distanceToDrive);
        prevError = error;
        updatePID();
    }

    protected void execute() {
        prevTime = System.currentTimeMillis();
        updatePID();
        drivetrain.driveStraight(Kp * error + Kd * deltaError); 
        System.out.println("Error: " +error+ "Motor: " + Kp * error);
    }
    
    protected void updatePID() {
         error = (vision.getDistance() - distanceToDrive);
         deltaError = (error - prevError) / ((double)(System.currentTimeMillis() - prevTime) / 1000.0);
         prevError = error;
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut() || ( (Math.abs(error) < 0.05) && (Math.abs(deltaError) < 0.05)); //Finish if timeout is reached, also when very close to target AND not moving
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
