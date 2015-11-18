package edu.art._4345.resQ.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Drivetrain {

    private DcMotor leftDrive, rightDrive;

    public Drivetrain(DcMotor leftDrive, DcMotor rightDrive) {
        this.leftDrive = leftDrive;
        this.rightDrive = rightDrive;

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
    }

    public void tankDrive(float leftPower, float rightPower) {
        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
    }

    public void arcadeDrive(float power, float turn) {
        float leftPower = power + turn;
        float rightPower = power - turn;

        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
    }
}
