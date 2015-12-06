package edu.art._4345.resQ.opModes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import edu.art._4345.resQ.subsystems.Drivetrain;
import edu.art._4345.resQ.subsystems.TriggerFlipper;

public class DriveTriggerOnly extends OpMode {
    
    private Drivetrain drivetrain;
    private TriggerFlipper triggerFlipper;

    @Override
    public void init() {
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("left_drive"), hardwareMap.dcMotor.get("right_drive"));
        triggerFlipper = new TriggerFlipper(hardwareMap.servo.get("trigger_flipper"), true);
    }

    @Override
    public void loop() {
            drivetrain.arcadeDrive(-1 * gamepad1.left_stick_y, gamepad1.right_stick_x);
        if (gamepad1.left_bumper) {
            if (!triggerFlipper.isExtended()) {
                triggerFlipper.extend();
                while(gamepad1.left_bumper);
            }
            else {
                triggerFlipper.stow();
                while(gamepad1.left_bumper);
            }
        }
    }

}
