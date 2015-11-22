package edu.art._4345.resQ.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

public class Drivetrain {

    private DcMotor leftDrive, rightDrive;

    public Drivetrain(DcMotor leftDrive, DcMotor rightDrive) {
        this.leftDrive = leftDrive;
        this.rightDrive = rightDrive;

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
    }

    public void tankDrive(float leftPower, float rightPower) {
        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
    }

    public void arcadeDrive(float power, float turn) {
        float leftPower = Range.clip(power + turn, -1, 1);
        float rightPower = Range.clip(power - turn, -1, 1);

        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
    }
}
