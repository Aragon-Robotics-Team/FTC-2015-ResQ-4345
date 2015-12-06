package edu.art._4345.resQ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import edu.art._4345.resQ.subsystems.Plow;

/**
 * Created by member on 12/5/15.
 */
public class PlowTest extends OpMode {
    private Plow plow;

    @Override
    public void init() {
        plow = new Plow(hardwareMap.servo.get("plow"));
    }

    @Override
    public void loop() {
        //plow control
        if(gamepad1.right_bumper) {
            plow.lift();
        }
        if(gamepad1.left_bumper) {
            plow.block();
        }
    }
}
