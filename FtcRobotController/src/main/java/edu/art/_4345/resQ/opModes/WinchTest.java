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
        //retracting/extending tape measure & string independently
        winch.tape(2 * (gamepad1.left_trigger - 0.5) * winch.tapePower);
        winch.pulley(2 * (gamepad1.right_trigger - 0.5) * winch.pulleyPower);

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
