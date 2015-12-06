package edu.art._4345.resQ.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Pullup {

    private final float AIMER_COEFFICIENT = .125;
    
    private DcMotor pulley, aimer;

    public Pullup(DcMotor pulley, DcMotor aimer) {
        this.pulley = pulley;
        this.aimer = aimer;
    }

    public void pull(float power) {
        pully.setPower(power);
    }

    public void aim(power) {
        aimer.setPower(power * AIMER_COEFFICIENT);
    }

}
