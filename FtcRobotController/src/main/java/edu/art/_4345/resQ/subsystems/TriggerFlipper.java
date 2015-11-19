package edu.art._4345.resQ.subsystems;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by member on 11/17/15.
 */
public class TriggerFlipper {

    private Servo flipper;

    public TriggerFlipper(Servo flipper){
        this.flipper = flipper;

        this.flipper.scaleRange(0, 1);
    }

    public void stowLeft() {
        flipper.setPosition(0);
    }

    public void stowRight() { flipper.setPosition(1); }

    public void extend(){
        flipper.setPosition(0.5);
    }
}
