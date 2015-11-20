package edu.art._4345.resQ.subsystems;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by member on 11/17/15.
 */
public class TriggerFlipper {

    private Servo flipper;

    private final double EXTENSION_POINT = 100.0 / 195.0;

    public TriggerFlipper(Servo flipper){
        this.flipper = flipper;

        this.flipper.scaleRange(0, EXTENSION_POINT);
    }

    public void stow() {
        flipper.setPosition(0);
    }

    public void extend(){
        flipper.setPosition(1);
    }

    public double getPosition() {
        return flipper.getPosition();
    }
}
