package frc.robot.subsystems;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {

    // Initialize a Network Table Instance
    private NetworkTable tableInstance = NetworkTableInstance.getDefault()
    .getTable("limelight");

    // Limelight target boolean
    public boolean vTar = false;

    // Send the data to SmartDashboard
    public static final boolean postSmartDashboard = true;

    // Verify connection to SmartDashboard
    public static boolean isConnected(boolean connected) {
        if (postSmartDashboard) {
            SmartDashboard.putBoolean("Limelight Connected", true);
        }
        return connected;
    }

    // Position values for Network Tables based off pipeline

    public double PosX() {
        return tableInstance.getEntry("tx").getDouble(0.0);
    }

    public double PosY() {
        return tableInstance.getEntry("ty").getDouble(0.0);
    }

    public double PosArea() {
        return tableInstance.getEntry("ta").getDouble(0.0);
    }

    public double PosHor() {
        return tableInstance.getEntry("thor").getDouble(0.0);
    }

    public double PosVert() {
        return tableInstance.getEntry("tvert").getDouble(0.0);
    }

    // Check for valid target (disregard is the range/area where target should be ignored)
    // TODO: verify this works???

    // TODO: EDIT LIMELIGHT HARDWARD CONTOURS, SPECIFICALLY THE SORT MODE AND SPECKLES

    public void validTarget(double disregard) {
        if (tableInstance.getEntry("ta").getDouble(0.0) > disregard)
        {
            vTar = true;
        }
        else
        {
            vTar = false;
        }
    }
}
