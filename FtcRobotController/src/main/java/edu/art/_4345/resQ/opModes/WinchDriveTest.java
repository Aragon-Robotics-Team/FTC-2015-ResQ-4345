package edu.art._4345.resQ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import edu.art._4345.resQ.subsystems.*;

/**
 * Teleop Op mode for use testing the winch subsystem.
 */
public class WinchDriveTest extends OpMode{

    private Winch winch;
    private Drivetrain drivetrain;

    private final double INCREMENT = 0.005;

    @Override
    public void init() {
        winch = new Winch(hardwareMap.dcMotor.get("tape_motor"), hardwareMap.dcMotor.get("aim_motor"), hardwareMap.dcMotor.get("pulley_motor"));
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("left_drive"), hardwareMap.dcMotor.get("right_drive"));
    }

    @Override
    public void loop() {
        //driving
        drivetrain.arcadeDrive(gamepad1.left_stick_y, gamepad1.right_stick_x);
        
        //retracting/extending tape measure & string independently
        winch.tape(2 * (gamepad2.left_trigger - 0.5) * winch.tapePower);
        winch.pulley(2 * (gamepad2.right_trigger - 0.5) * winch.pulleyPower);

        //aiming tape measure
        winch.aim(gamepad2.left_stick_y);

        //controlling tape motor speed
        if(gamepad2.dpad_up)
            winch.changeTapePower(INCREMENT);
        else if(gamepad2.dpad_down)
            winch.changeTapePower(-INCREMENT);

        //controlling pulley motor speed
        if(gamepad2.y)
            winch.changePulleyPower(INCREMENT);
        else if(gamepad2.a)
            winch.changePulleyPower(-INCREMENT);

        telemetry.addData("Tape power: ", winch.tapePower);
        telemetry.addData("Pulley power: ", winch.pulleyPower);
    }
}
