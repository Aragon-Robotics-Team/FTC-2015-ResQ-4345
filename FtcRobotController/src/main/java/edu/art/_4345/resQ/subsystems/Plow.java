package edu.art._4345.resQ.subsystems;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by member on 12/5/15.
 */
public class Plow {

    private final double LIFT_POSITION = 1;

    private Servo plow;
    private boolean isDown;

    public Plow(Servo plow) {
        this.plow = plow;
        plow.scaleRange(0, LIFT_POSITION);

        isDown = false;
    }

    public void block() {
        plow.setPosition(0);
        isDown = true;
    }

    public void lift() {
        plow.setPosition(1);
        isDown = false;
    }

    public void toggle() {
        if(isDown) {
            lift();
        }
        else {
            block();
        }
    }
}
