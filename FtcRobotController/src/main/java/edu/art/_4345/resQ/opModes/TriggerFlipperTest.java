package edu.art._4345.resQ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import edu.art._4345.resQ.subsystems.TriggerFlipper;

/**
 * Created by member on 11/19/15.
 */
public class TriggerFlipperTest extends OpMode {

    TriggerFlipper flipperLeft;
    TriggerFlipper flipperRight;

    @Override
    public void init() {
        flipperLeft = new TriggerFlipper(hardwareMap.servo.get("trigger_flipper_left"));
        flipperRight = new TriggerFlipper(hardwareMap.servo.get("trigger_flipper_right"));
    }

    @Override
    public void loop() {
        if (gamepad1.left_bumper) {
            if (!flipperLeft.isExtended()) {
                flipperLeft.extend();
                while(gamepad1.left_bumper);
            }
            else {
                flipperLeft.stow();
                while(gamepad1.left_bumper);
            }
        }
        if (gamepad1.left_trigger > 0.5) {
            if (!flipperRight.isExtended()) {
                flipperRight.extend();
                while(gamepad1.left_trigger > 0.5);
            }
            else {
                flipperLeft.stow();
                while(gamepad1.left_trigger > 0.5);
            }
        }
    }

}