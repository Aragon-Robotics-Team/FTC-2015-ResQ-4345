package edu.art._4345.resQ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import edu.art._4345.resQ.subsystems.Drivetrain;

/**
 * A very simple autonomous op mode that drives into the parking zone.
 */
public class SimpleAutonomous extends LinearOpMode {

    private Drivetrain drivetrain;

    private final double INCHES_PER_SECOND = 10; //dummy value
    private final double SECONDS_PER_ROTATION = 5; //dummy value

    private final int SQUARES = 3; //squares from mountain (3 and 4 are next to middle)
    private final boolean onRedTeam = true;

    @Override
    public void runOpMode() throws InterruptedException {
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("left_drive"), hardwareMap.dcMotor.get("right_drive"));

        waitForStart();

        if(SQUARES == 3) {
            driveForward(27);
            turn(45);
            driveForward(33.94);
            turn(45);
            driveForward(27);
        }
        else if(SQUARES == 4) {
            driveForward(15);
            turn(45);
            driveForward(50.91);
            turn(45);
            driveForward(39);
        }
    }

    private void driveForward(double inches) throws InterruptedException {
        drivetrain.arcadeDrive(1, 0);
        sleep(1000 * (long)(inches / INCHES_PER_SECOND));
        drivetrain.arcadeDrive(0, 0);
    }

    private void turn(double degrees) throws InterruptedException {
        if (onRedTeam)
            turnCounterclockwise(degrees);
        else
            turnClockwise(degrees);
    }

    private void turnCounterclockwise(double degrees) throws InterruptedException {
        drivetrain.arcadeDrive(0, -1);
        sleep(1000 * (long)((degrees / 360) * SECONDS_PER_ROTATION));
        drivetrain.arcadeDrive(0, 0);
    }

    private void turnClockwise(double degrees) throws InterruptedException {
        drivetrain.arcadeDrive(0, 1);
        sleep(1000 * (long)((degrees / 360) * SECONDS_PER_ROTATION));
        drivetrain.arcadeDrive(0, 0);
    }
}