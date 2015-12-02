package edu.art._4345.resQ.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import edu.art._4345.resQ.subsystems.Winch;

/**
 * Teleop Op mode for use testing the winch subsystem.
 */
public class WinchTest extends OpMode {

    private Winch winch;

    private final double TAPE_POWER = 0.25;

    @Override
    public void init() {
        winch = new Winch(hardwareMap.dcMotor.get("tape_motor"), hardwareMap.dcMotor.get("aim_motor"));
    }

    @Override
    public void loop() {
        //retracting/extending tape measure
        winch.tape(gamepad1.left_stick_y * TAPE_POWER);
        
        //aiming tape measure
        if (gamepad2.left_bumper)
            winch.aim(1);
        else if(gamepad2.left_trigger > 0.5)
            winch.aim(-1);
        else
            winch.aim(0);
    }
}
