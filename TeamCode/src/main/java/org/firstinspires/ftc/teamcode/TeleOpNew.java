package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "TeleOpNew", group = "Examples")
public class TeleOpNew extends LinearOpMode {

    private DcMotor motor1;
    private DcMotor motor2;
    private DriveTeleOp drive;
    private String robotState = "IDLE";
    private intake intake;

    @Override
    public void runOpMode() throws InterruptedException{
        motor1 = hardwareMap.get(DcMotor.class,"master3");
        motor2 = hardwareMap.get(DcMotor.class,"slave3");
        drive = new DriveTeleOp(hardwareMap, telemetry);
        intake = new intake(hardwareMap, telemetry);

        motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        motor2.setDirection(DcMotorSimple.Direction.REVERSE);

        motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

//        PIDcontroller pid = new PIDcontroller(0, 0, 0, 0, 0);
        int targetPosition = 200; // כאן צריך לעשות המרה לזוויות

        ElapsedTime timer = new ElapsedTime();
        double previousTime = timer.seconds();
        robotState = "IDLE";

        waitForStart();

        while(opModeIsActive()) {

            drive.fieldCentricUsingGamePad(gamepad1);

            telemetry.addData("distans", intake.getDistanceSensor().senseGamePiece());

            double stickPosition = -gamepad2.left_stick_y;
            boolean manualModeFlag = true;
            double deadZone = 0.05;

            //בדיקה של כפתור ידני או אוטמוטי

            manualModeFlag = !gamepad2.circle;

            //ידני
            if (manualModeFlag){
                //אם הג'ויסטיק זז מספיק
                if (Math.abs(stickPosition) > deadZone){

                    motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


                    motor1.setPower(stickPosition * 0.8);
                    motor2.setPower(stickPosition * 0.8);

                    targetPosition = motor1.getCurrentPosition();
                    telemetry.addData("current position:", targetPosition);

                }
                //אם הג'ויטיק לא לחוץ
                else if (gamepad2.dpad_up) {
                    motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                    motor1.setPower(0.4 + getFeedForward(((motor1.getCurrentPosition() / 288f ) * 360f)));
                    motor2.setPower(0.4 + getFeedForward(((motor1.getCurrentPosition() / 288f ) * 360f)));

                    targetPosition = motor1.getCurrentPosition();
                    telemetry.addData("current position:", targetPosition);
                } else if (gamepad2.dpad_down) {
                    motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                    motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                    motor1.setPower(-0.4 + getFeedForward(((motor1.getCurrentPosition() / 288f ) * 360f)));
                    motor2.setPower(-0.4 + getFeedForward(((motor1.getCurrentPosition() / 288f ) * 360f)));

                    targetPosition = motor1.getCurrentPosition();
                    telemetry.addData("current position:", targetPosition);
                } else{
                    motor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                    motor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

                    if (motor1.getCurrentPosition() <= 90) {
                        motor1.setPower(getFeedForward(((motor1.getCurrentPosition() / 288f ) * 360f)));
                        motor2.setPower(getFeedForward(((motor1.getCurrentPosition() / 288f ) * 360f)));
                    }

                    else if (motor1.getCurrentPosition() > 93) {
                        motor1.setPower(getFeedForward(((motor1.getCurrentPosition() / 288f ) * 360f)));
                        motor2.setPower(getFeedForward(((motor1.getCurrentPosition() / 288f ) * 360f)));
                    }
                    telemetry.addData("Master Position", motor1.getCurrentPosition());
                }
            }
            if (gamepad1.left_bumper) {
                robotState = "INTAKE";
            }

            if (gamepad1.right_bumper) {
                robotState = "COLLECTGAMEPICE";
            }

            if (gamepad1.touchpad){
                robotState = "IDLE";
            }
            if (gamepad2.touchpad){
                robotState = "IDLE";
            }

            if (gamepad1.a) {
                intake.intakespeed(-1);
            }
            if (gamepad1.b){
                intake.stopIntake();
            }

            if (robotState == "INTAKE" && !intake.getDistanceSensor().senseGamePiece()) {
//                arm.armSetSetPoint(HP);
                intake.setintake();

            }
            if (robotState == "INTAKE" && intake.getDistanceSensor().senseGamePiece()) {
                intake.stopIntake();
//                arm.armSetSetPoint(SPECIMEN);
                robotState = "IDLE";
            }

            if (robotState == "COLLECTGAMEPICE" && !intake.getDistanceSensor().senseGamePiece7cm()) {
                intake.setintake();
            }
            if (robotState == "COLLECTGAMEPICE" && intake.getDistanceSensor().senseGamePiece7cm()){
                intake.stopIntake();

                robotState = "IDLE";
            }

            telemetry.update();


            //אוטומטי
//            else{
//
//                double currentTime = timer.seconds();
//                double dt = currentTime - previousTime;
//                previousTime = currentTime;
//
//                double currentPosition = motor1.getCurrentPosition();
//                double output = pid.Update(targetPosition, currentPosition, dt);
//                output = Math.max(-1, Math.min(1, output)); // Clamp to valid motor power
//
//                motor1.setPower(output);
//                motor2.setPower(output);

//            }





        }






    }
    public double getFeedForward(double current) {
        return Math.sin(Math.toRadians(current) + 20) * 0.38;}
}
//0.32v