package edu.art._4345.resQ.subsystems;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by member on 12/5/15.
 */
public class Plow {

    private Servo plow;
    private final double LIFT_POSITION = 1;                 //dummy value

    public Plow(Servo plow) {
        this.plow = plow;

        plow.scaleRange(0, LIFT_POSITION);
    }

    public void block() {
        plow.setPosition(0);
    }

    public void lift() {
        plow.setPosition(LIFT_POSITION);
    }
}
