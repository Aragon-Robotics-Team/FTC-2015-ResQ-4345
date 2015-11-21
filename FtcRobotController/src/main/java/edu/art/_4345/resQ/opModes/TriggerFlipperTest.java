package edu.art._4345.resQ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import edu.art._4345.resQ.subsystems.TriggerFlipper;

/**
 * Created by member on 11/19/15.
 */
public class TriggerFlipperTest extends OpMode{

    TriggerFlipper flipper;

    @Override
    public void init() {
        flipper = new TriggerFlipper(hardwareMap.servo.get("trigger_flipper"));
    }

    @Override
    public void loop() {
        if (gamepad1.left_bumper) {
            if (!flipper.isExtended()) {
                flipper.extend();
                while(gamepad1.left_bumper);
            }
            else {
                flipper.stow();
                while(gamepad1.left_bumper);
            }
        }
    }

}