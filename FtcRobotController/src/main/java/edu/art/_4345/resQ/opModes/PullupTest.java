package edu.art._4345.resQ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import edu.art._4345.resQ.subsystems.Pullup;

/**
 * Created by member on 12/5/15.
 */
public class PullupTest extends OpMode{

    private Pullup pullup;

    @Override
    public void init() {
        pullup = new Pullup(hardwareMap.dcMotor.get("puller"), hardwareMap.dcMotor.get("aimer"));
    }

    @Override
    public void loop() {
        pullup.pull(-1 * gamepad1.left_stick_y);
        pullup.aim(-1 * gamepad1.right_stick_y);
        telemetry.addData("asdfs", 64);
    }
}
