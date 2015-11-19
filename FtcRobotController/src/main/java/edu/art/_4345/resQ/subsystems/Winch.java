package edu.art._4345.resQ.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Winch {

    private DcMotor extendMotor, aimMotor, pullMotor;

    public Winch(DcMotor extendMotor, DcMotor aimMotor, DcMotor pullMotor) {
        this.extendMotor = extendMotor;
        this.aimMotor = aimMotor;
        this.pullMotor = pullMotor;

        this.extendMotor.setDirection(DcMotor.Direction.FORWARD);
        this.aimMotor = aimMotor;
        this.pullMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void extend(double power) {
        extendMotor.setPower(power);
    }

    public void aim(double power) {
        aimMotor.setPower(power);
    }

    public void pull(double power) {
        pullMotor.setPower(power);
    }
}
