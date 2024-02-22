package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;

public class DriveToTarget  extends CommandBase {
    private final Limelight m_lime;
    private final DriveTrain m_drive;

    // Initialize Drive Command
    public DriveToTarget(Limelight lime, DriveTrain drive) {
        m_lime = lime;
        m_drive = drive;
    }

    public void initialize() {
        m_drive.getHeading();
    }

    // While scheduler runs, this will run
    public void execute() {
        if (m_lime.hasValidTarget() == true)
            {
                m_drive.drive(
                DriveConstants.kMaxSpeedMetersPerSecond, 
                DriveConstants.kMaxSpeedMetersPerSecond, 
                m_lime.m_LimelightSteerCommand, 
                true, 
                true);
            }
            else {
                m_drive.setX();
            }
    }

    // If command is interrupted, stops the robot
    public void end(boolean interrupted) {
        m_drive.setX();
    }

    // Returns at the end of the scheduled command
    public boolean isFinished() {
        return m_lime.m_LimelightTargetArea == 50;
    }
}

