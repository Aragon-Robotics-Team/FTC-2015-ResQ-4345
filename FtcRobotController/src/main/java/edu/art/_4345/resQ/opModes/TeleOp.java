package edu.art._4345.resQ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import edu.art._4345.resQ.subsystems.*;

/**
 * Teleop Op mode combing all subsystems.
 */
public class TeleOp extends OpMode {

    private Drivetrain drivetrain;
    private TriggerFlipper leftFlipper, rightFlipper;
    private Plow plow;

    private final double INCREMENT = 0.005;

    @Override
    public void init() {
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("left_drive"), hardwareMap.dcMotor.get("right_drive"));
        leftFlipper = new TriggerFlipper(hardwareMap.servo.get("trigger_flipper_left"), true);
        rightFlipper = new TriggerFlipper(hardwareMap.servo.get("trigger_flipper_right"), false);
        plow = new Plow(hardwareMap.servo.get("plow"));
    }

    @Override
    public void loop() {
        //driving
        drivetrain.arcadeDrive(gamepad1.left_stick_y, gamepad1.right_stick_x);


        //trigger flipper control
        if(gamepad2.a) {
            leftFlipper.toggle();
            while(gamepad2.a);
        }
        else if(gamepad2.b) {
            rightFlipper.toggle();
            while(gamepad2.b);
        }

        //plow control
        if(gamepad1.right_bumper) {
            plow.lift();
        }
        if(gamepad1.left_bumper) {
            plow.block();
        }


    }
}
