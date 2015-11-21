public class DriveTriggerOnly extends OpMode {
    
    private Drivetrain drivetrain;
    private TriggerFlipper triggerFlipper;

    @Override
    public void init() {
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("left_drive"), hardwareMap.dcMotor.get("right_drive"));
        flipper = new TriggerFlipper(hardwareMap.servo.get("trigger_flipper"));
    }

    @Override
    public void loop() {
            drivetrain.arcadeDrive(-1 * gamepad1.left_stick_y, gamepad1.right_stick_x);
        if (gamepad1.left_bumper) {
            if (!flipper.isExtended()) {
                flipper.extend();
                while(gamepad1.left_bumper);
            }
            else {
                flipper.stow();
                while(gamepad1.left_bumper);
            }
        }
    }

}
