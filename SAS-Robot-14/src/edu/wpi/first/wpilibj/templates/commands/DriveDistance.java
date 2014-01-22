package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.templates.subsystems.Vision;

/**
 *
 * @author Samsung
 */
public class DriveDistance extends CommandBase {
    
    private boolean stopped = false;
    
    public DriveDistance() {
        requires(drivetrain);
        requires(vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    protected void execute() {
        if(!stopped){
            drivetrain.tankDrive(0, 0);
            stopped = true;
        }
        new UpdateDistance();
        System.out.print(vision);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stopped;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
