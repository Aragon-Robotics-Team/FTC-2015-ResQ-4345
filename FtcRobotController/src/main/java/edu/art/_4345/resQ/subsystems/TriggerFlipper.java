package edu.art._4345.resQ.subsystems;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by member on 11/17/15.
 */
public class TriggerFlipper {

    private Servo flipper;
    private boolean extended;

    private final double EXTENSION_POINT = 95.0 / 195.0;

    public TriggerFlipper(Servo flipper){
        this.flipper = flipper;

        this.flipper.scaleRange(EXTENSION_POINT, 1.0);
    }

    public void stow() {
        flipper.setPosition(1);
        extended = false;
    }

    public void extend(){
        flipper.setPosition(0);
        extended = true;
    }

    public boolean isExtended() {
        return extended;
    }
}
