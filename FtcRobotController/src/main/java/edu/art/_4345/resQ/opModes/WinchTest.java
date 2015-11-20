package edu.art._4345.resQ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import edu.art._4345.resQ.subsystems.Winch;

/**
 * Teleop Op mode for use testing the winch subsystem.
 */
public class WinchTest extends OpMode{

    private Winch winch;

    private final double INCREMENT = 0.005;

    @Override
    public void init() {
        winch = new Winch(hardwareMap.dcMotor.get("tape_motor"), hardwareMap.dcMotor.get("aim_motor"), hardwareMap.dcMotor.get("pulley_motor"));
    }

    @Override
    public void loop() {
        //extending tape meausre and string
        if(gamepad1.right_trigger == 1.0)
            winch.extend(1.0);
        else if(gamepad1.right_bumper)
            winch.extend(-1.0);
        else
            winch.extend(0);

        //controlling tape motor speed
        if(gamepad1.dpad_up)
            winch.changeTapePower(INCREMENT);
        else if(gamepad1.dpad_down)
            winch.changeTapePower(-INCREMENT);

        //controlling pulley motor speed
        if(gamepad1.y)
            winch.changePulleyPower(INCREMENT);
        else if(gamepad1.a)
            winch.changePulleyPower(-INCREMENT);

        telemetry.addData("Tape power: ", winch.tapePower);
        telemetry.addData("Pulley power: ", winch.pulleyPower);
    }
}
