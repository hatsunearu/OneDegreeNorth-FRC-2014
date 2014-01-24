package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotConstants;

/**
 *
 * @author Samsung
 */
public class DriveDistance extends CommandBase {
    
    double distanceToDrive = RobotConstants.DriveDistance;
    double Kp = RobotConstants.DriveDistanceKp;
    double Ki = RobotConstants.DriveDistanceKi;
    double error, errorSum = 0;
    
    public DriveDistance() {
        requires(drivetrain);
        requires(vision);
        this.setTimeout(RobotConstants.DriveDistanceTimeout);
        errorSum = 0;
    }
    
    public DriveDistance(double distance) {
        distanceToDrive = distance;
        requires(drivetrain);
        requires(vision);
        this.setTimeout(RobotConstants.DriveDistanceTimeout);
        errorSum = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        errorSum = 0;
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
        if (Math.abs(speed) > RobotConstants.DriveDistanceSpeedLimit) {
            speed = (RobotConstants.DriveDistanceSpeedLimit * getSign(speed));
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
        drivetrain.driveStraight((0));
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
