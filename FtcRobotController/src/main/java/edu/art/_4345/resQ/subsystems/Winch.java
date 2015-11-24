package edu.art._4345.resQ.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

public class Winch {

    private DcMotor tapeMotor, aimMotor, pulleyMotor;

    private final double AIM_POWER_FORWARD = 0.3;
    private final double AIM_POWER_BACK = 0.1;
    public double tapePower, pulleyPower;

    public Winch(DcMotor tapeMotor, DcMotor aimMotor, DcMotor pulleyMotor) {
        this.tapeMotor = tapeMotor;
        this.aimMotor = aimMotor;
        this.pulleyMotor = pulleyMotor;

        this.tapeMotor.setDirection(DcMotor.Direction.FORWARD);
        this.aimMotor.setDirection(DcMotor.Direction.FORWARD);
        this.pulleyMotor.setDirection(DcMotor.Direction.FORWARD);

        tapePower = 0.25;
        pulleyPower = 1.0;
    }

    public void extend(double power) {
        tape(tapePower * power);
        pulley(pulleyPower * power);
    }

    public void changeTapePower(double change) {
        tapePower = Range.clip(tapePower + change, -1.0, 1.0);
    }

    public void changePulleyPower(double change) {
        pulleyPower = Range.clip(pulleyPower + change, -1.0, 1.0);
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

    public void pulley(double power) {
        pulleyMotor.setPower(power);
    }
}
