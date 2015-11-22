package edu.art._4345.resQ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import edu.art._4345.resQ.subsystems.*;

/**
 * Teleop Op mode combing all subsystems.
 */
public class TeleOp extends OpMode {

    private Winch winch;
    private Drivetrain drivetrain;
    private TriggerFlipper leftFlipper, rightFlipper;

    private final double INCREMENT = 0.005;

    @Override
    public void init() {
        winch = new Winch(hardwareMap.dcMotor.get("tape_motor"), hardwareMap.dcMotor.get("aim_motor"), hardwareMap.dcMotor.get("pulley_motor"));
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("left_drive"), hardwareMap.dcMotor.get("right_drive"));
        leftFlipper = new TriggerFlipper(hardwareMap.servo.get("trigger_flipper_left"), true);
        rightFlipper = new TriggerFlipper(hardwareMap.servo.get("trigger_flipper_right"), false);
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

        //retracting/extending tape measure & string independently
        winch.tape(gamepad2.left_stick_y * winch.tapePower);
        winch.pulley(gamepad2.right_stick_y * winch.pulleyPower);

        //aiming tape measure
        if (gamepad2.left_bumper)
            winch.aim(1);
        else if(gamepad2.left_trigger > 0.5)
            winch.aim(-1);
        else
            winch.aim(0);

        //controlling tape motor speed
        if(gamepad2.dpad_up) {
            winch.changeTapePower(INCREMENT);
        }
        else if(gamepad2.dpad_down) {
            winch.changeTapePower(-INCREMENT);
        }

        //controlling pulley motor speed
        if(gamepad2.y)
            winch.changePulleyPower(INCREMENT);
        else if(gamepad2.x)
            winch.changePulleyPower(-INCREMENT);

        telemetry.addData("Tape power: ", winch.tapePower);
        telemetry.addData("Pulley power: ", winch.pulleyPower);
    }
}
