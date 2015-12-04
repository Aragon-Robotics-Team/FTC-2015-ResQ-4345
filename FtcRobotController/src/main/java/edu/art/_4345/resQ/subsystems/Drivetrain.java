package edu.art._4345.resQ.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

public class Drivetrain {

    private DcMotor leftDrive, rightDrive;
    private final float CREEP_SPEED;
    
    public Drivetrain(DcMotor leftDrive, DcMotor rightDrive) {
        this.leftDrive = leftDrive;
        this.rightDrive = rightDrive;

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
    }

    public void arcadeDrive(float power, float turn, boolean creep) {
        float leftPower = Range.clip(power - turn, -1, 1);
        float rightPower = Range.clip(power + turn, -1, 1);
        
        if(!creep) {
            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);
        }
        else {
            leftDrive.setPower(leftPower * CREEP_SPEED);
            rightDrive.setPower(rightPower * CREEP_SPEED);
        }
    }
}
