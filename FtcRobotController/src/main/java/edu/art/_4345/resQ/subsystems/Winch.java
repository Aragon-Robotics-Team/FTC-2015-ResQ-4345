package edu.art._4345.resQ.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

public class Winch {

    private DcMotor aimMotor, tapeMotor;

    private final double AIM_POWER_FORWARD = 0.3;
    private final double AIM_POWER_BACK = 0.1;

    public Winch(DcMotor tapeMotor, DcMotor aimMotor) {
        this.tapeMotor = tapeMotor;
        this.aimMotor = aimMotor;

        this.tapeMotor.setDirection(DcMotor.Direction.FORWARD);
        this.aimMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void tape(double power) {
        tapeMotor.setPower(power);
    }

    public void aim(double power) {
        if(power > 0)
            aimMotor.setPower(AIM_POWER_FORWARD * power);
        else
            aimMotor.setPower(AIM_POWER_BACK * power);
    }
}
