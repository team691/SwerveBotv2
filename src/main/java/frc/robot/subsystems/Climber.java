package frc.robot.subsystems;

// Imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.DoubleSolenoid;

// Pneumatic Climber
public class Climber extends SubsystemBase{

    // Position/Status of the Solenoid/Pneumatic (Up vs. Down)
    private DoubleSolenoid.Value state = DoubleSolenoid.Value.kReverse;
    // ID number 9 in REV
    private final PneumaticHub pHub = new PneumaticHub(9);
    // On Pneumatic Hub ports 0 and 1
    private final DoubleSolenoid sole1 = pHub.makeDoubleSolenoid(0,1);

    public void AccuateUp() {
        state = DoubleSolenoid.Value.kForward;
        sole1.set(state);
    }

    public void AcctuateDown() {
        state = DoubleSolenoid.Value.kReverse;
        sole1.set(state);
    }    
}