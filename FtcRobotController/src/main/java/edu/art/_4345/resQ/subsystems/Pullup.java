package edu.art._4345.resQ.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Pullup {

    private final float AIMER_COEFFICIENT =0.25f;
    
    private DcMotor puller, aimer;

    public Pullup(DcMotor puller, DcMotor aimer) {
        this.puller = puller;
        this.aimer = aimer;

        puller.setDirection(DcMotor.Direction.REVERSE);
        aimer.setDirection(DcMotor.Direction.REVERSE);
    }

    public void pull(float power) {
        puller.setPower(power);
    }

    public void aim(float power) {
        aimer.setPower(power * AIMER_COEFFICIENT);
    }

}
