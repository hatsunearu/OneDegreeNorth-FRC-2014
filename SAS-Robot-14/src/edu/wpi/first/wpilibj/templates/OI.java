
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.IntakeIn;
import edu.wpi.first.wpilibj.templates.commands.IntakeOut;
import edu.wpi.first.wpilibj.templates.commands.LauncherReset;
import edu.wpi.first.wpilibj.templates.commands.LauncherShoot;
import edu.wpi.first.wpilibj.templates.commands.LauncherShootAndReset;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    Joystick joypad = new Joystick(1);
    
        Button button1 = new JoystickButton(joypad, 1), //A
            button2 = new JoystickButton(joypad, 2), //B
            button3 = new JoystickButton(joypad, 3), //X
            button4 = new JoystickButton(joypad, 4), //Y
            button5 = new JoystickButton(joypad, 5),
            button6 = new JoystickButton(joypad, 6),
            button7 = new JoystickButton(joypad, 7),
            button8 = new JoystickButton(joypad, 8), //back
            button9 = new JoystickButton(joypad, 9); //select
    
    public OI() {
        button1.whenPressed(new IntakeIn());
        button2.whenPressed(new IntakeOut());
        button5.whenPressed(new LauncherShoot());
        button6.whenPressed(new LauncherReset());
        button7.whenPressed(new LauncherShootAndReset());
    }
        
    /*
    public int getLeftTrigger(){
        if(joypad.getRawAxis(5) < 0){
            return -1;
        }else{
            return 0;
        }
    }
    
    public int getRightTrigger(){
        if(joypad.getRawAxis(5) > 0){
            return 1;
        }else{
            return 0;
        }
    }
    */
    public double getLeftStick() {
        if (Math.abs(joypad.getRawAxis(2)) < 0.05)
            return 0;
        return joypad.getRawAxis(2);        
    }
    
    public double getRightStick() {
        if (Math.abs(joypad.getRawAxis(5)) < 0.05)
            return 0;
        return joypad.getRawAxis(5);  
    }
}

