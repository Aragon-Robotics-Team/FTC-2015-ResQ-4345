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
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("left_drive"), hardwareMap.dcMotor.get("right_drive"));
    }

    @Override
    public void loop() {
        if(gamepad1.a) {
            drivetrain.tankDrive(-1 * gamepad1.left_stick_y, -1 * gamepad1.right_stick_y);
        }
        else {
            if(gamepad2.left_trigger > 0.5) {
	            drivetrain.arcadeDrive(gamepad1.left_stick_y, gamepad1.right_stick_x, true);
	        }
	        else {
	            drivetrain.arcadeDrive(gamepad1.left_stick_y, gamped1.right_stick_x, false);
	        }
        }
    }
}
