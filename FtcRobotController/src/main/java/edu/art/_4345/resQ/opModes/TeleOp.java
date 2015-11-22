package edu.art._4345.resQ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import edu.art._4345.resQ.subsystems.*;

/**
 * Teleop Op mode combing all subsystems.
 */
public class TeleOp extends OpMode {

    private Winch winch;
    private Drivetrain drivetrain;
    private TriggerFlipper leftFlipper, rightFlipper;

    private Gamepad driver = gamepad1, controller = gamepad2;
    private boolean driverIs1 = true;

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
        //switching driver/controller
        if(driver.start || controller.start) {
            if(driverIs1) {
                driver = gamepad2;
                controller = gamepad1;
            }
            else {
                driver = gamepad1;
                controller = gamepad2;
            }
            driverIs1 = !driverIs1;
            while(driver.start || controller.start);
        }


        //driving
        drivetrain.arcadeDrive(driver.left_stick_y, driver.right_stick_x);


        //trigger flipper control
        if(controller.a) {
            leftFlipper.toggle();
            while(controller.a);
        }
        else if(controller.b) {
            rightFlipper.toggle();
            while(controller.b);
        }

        //retracting/extending tape measure & string independently
        winch.tape(controller.left_stick_y * winch.tapePower);
        winch.pulley(controller.right_stick_y * winch.pulleyPower);

        //aiming tape measure
        if (controller.left_bumper)
            winch.aim(1);
        else if(controller.left_trigger > 0.5)
            winch.aim(-1);
        else
            winch.aim(0);

        //controlling tape motor speed
        if(controller.dpad_up) {
            winch.changeTapePower(INCREMENT);
        }
        else if(controller.dpad_down) {
            winch.changeTapePower(-INCREMENT);
        }

        //controlling pulley motor speed
        if(controller.y)
            winch.changePulleyPower(INCREMENT);
        else if(controller.x)
            winch.changePulleyPower(-INCREMENT);

        telemetry.addData("Tape power: ", winch.tapePower);
        telemetry.addData("Pulley power: ", winch.pulleyPower);
    }
}
