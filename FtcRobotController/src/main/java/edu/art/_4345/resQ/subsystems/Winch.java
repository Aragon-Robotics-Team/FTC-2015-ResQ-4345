package edu.art._4345.resQ.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Winch {

    private DcMotor hookMotor, pullMotor;

    public Winch(DcMotor hookMotor, DcMotor pullMotor) {
        this.hookMotor = hookMotor;
        this.pullMotor = pullMotor;

        this.hookMotor.setDirection(DcMotor.Direction.FORWARD);
        this.pullMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void hook(double power) {
        hookMotor.setPower(power);
    }

    public void pull(double power) {
        hookMotor.setPower(power);
    }
}
