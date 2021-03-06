package com.sasrobotics.FRC2014.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.sasrobotics.FRC2014.templates.OI;
import com.sasrobotics.FRC2014.subsystems.Drivetrain;
import com.sasrobotics.FRC2014.subsystems.Vision;
import com.sasrobotics.FRC2014.subsystems.Launcher;
import com.sasrobotics.FRC2014.subsystems.Intake;
/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static Vision vision = new Vision();
    public static Drivetrain drivetrain = new Drivetrain();
    public static Launcher launcher = new Launcher();
    public static Intake intake = new Intake();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(vision);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }

}
