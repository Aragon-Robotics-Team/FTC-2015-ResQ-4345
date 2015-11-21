package edu.art._4345.resQ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import edu.art._4345.resQ.subsystems.Drivetrain;

import java.lang.Math;

/**
 * A very simple autonomous op mode that drives into the parking zone.
 */
public class SimpleAutonomous extends LinearOpMode {

    private Drivetrain drivetrain;

    private final double INCHES_PER_SECOND = 5; //dummy value
    private final double SECONDS_PER_ROTATION = 5; //dummy value

    private final int SQUARE = 3; //squares from mountain (3 and 4 are next to middle)

    @Override
    public void runOpMode() throws InterruptedException {
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("left_drive"), hardwareMap.dcMotor.get("right_drive"));

        if(SQUARE == 3) {
            driveForward(27);
            turnCounterclockwise(45);
            driveForward(33.94);
            turnCounterclockwise(45);
            driveForward(27);
        }
        else if(SQUARE == 4) {
            driveForward(15);
            turnCounterclockwise(45);
            driveForward(50.91);
            turnCounterclockwise(45);
            driveForward(39);
        }
    }

    private long doubleToLong(double d) {
        long l;
        for (l = 0; l < d; l++);
        return l;
    }

    private void driveForward(double inches) throws InterruptedException {
        drivetrain.arcadeDrive(1, 0);
        wait(1000 * doubleToLong(inches / INCHES_PER_SECOND));
        drivetrain.tankDrive(0, 0);
    }

    private void turnCounterclockwise(double degrees) throws InterruptedException {
        drivetrain.arcadeDrive(0, -1);
        wait(1000 * doubleToLong((degrees / 360) * SECONDS_PER_ROTATION));
        drivetrain.arcadeDrive(0, 0);
    }

    private void turnClockwise(double degrees) throws InterruptedException {
        drivetrain.arcadeDrive(0, 1);
        wait(1000 * doubleToLong((degrees / 360) * SECONDS_PER_ROTATION));
        drivetrain.arcadeDrive(0, 0);
    }
}
