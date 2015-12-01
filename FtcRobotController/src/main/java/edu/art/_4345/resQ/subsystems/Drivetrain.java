package edu.art._4345.resQ.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import java.lang.Math;

public class Drivetrain {

    private DcMotor leftDrive, rightDrive;
    
    private final int TPR = 1440; //ticks per rotation
    private final double DPR = 5; //distance (in inches) per rotation **dummy value**
    private final double ROBOT_WIDTH = 16; //distance between two treads **dummy value**
    
    private final double ROBOT_CIRCUMFERENCE = ROBOT_WIDTH * Math.PI;

    public Drivetrain(DcMotor leftDrive, DcMotor rightDrive) {
        this.leftDrive = leftDrive;
        this.rightDrive = rightDrive;

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        
        leftDrive.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightDrive.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
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
    
    public void driveForward(double inches) {
    	double ticks = inches / DPR * TPR;
    	double startingTicks = leftDrive.getCurrentPosition();
    	arcadeDrive(1, 0);
    	while(leftDrive.getCurrentPosition() < startingTicks + ticks);
    	arcadeDrive(0, 0);
    }
    
    public void turnCounterclockwise(double degrees) {
    	double ticks = degrees / 360 / ROBOT_CIRCUMFERENCE / DPR * TPR;
    	double startingTicks = rightDrive.getCurrentPosition();
    	arcadeDrive(0, -1);
    	while(rightDrive.getCurrentPosition() < startingTicks + ticks);
    	arcadeDrive(0, 0);
    }
    public void turnClockwise(double degrees) {
    	double ticks = degrees / 360 / ROBOT_CIRCUMFERENCE / DPR * TPR;
    	double startingTicks = leftDrive.getCurrentPosition();
    	arcadeDrive(0, 1);
    	while(leftDrive.getCurrentPosition() < startingTicks + ticks);
    	arcadeDrive(0, 0);
    }
}
