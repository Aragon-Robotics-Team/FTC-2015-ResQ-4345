package edu.art._4345.resQ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import edu.art._4345.resQ.subsystems.Drivetrain;

/**
 * Teleop Op mode for use testing the drivetrain subsystem.
 */
public class DrivetrainTest extends OpMode{

    private Drivetrain drivetrain;

    @Override
    public void init() {
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("left_motor"), hardwareMap.dcMotor.get("right_motor"));
    }

    @Override
    public void loop() {
        if(gamepad1.a)
            drivetrain.tankDrive(-1 * gamepad1.left_stick_y, -1 * gamepad1.right_stick_y);
        else
            drivetrain.arcadeDrive(-1 * gamepad1.left_stick_y, gamepad1.right_stick_x);
    }
}
