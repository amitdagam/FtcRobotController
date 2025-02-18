package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.intake;



import org.firstinspires.ftc.robotcore.external.Telemetry;
//@Autonomous(name = "NetZoneAndPark", group = "Examples")
//public class NetZoneAndPark extends LinearOpMode {
//    private DcMotor leftFront;
//    private DcMotor rightFront;
//    private DcMotor leftRear;
//    private DcMotor rightRear;
//    private IMU imu;
//    private Telemetry telemetry;
//    private intake intake;
//    //private Arm arm;
//    private ElapsedTime timer;
//
//    private void startMotors() {
//        leftFront.setPower(0.5);
//        leftRear.setPower(0.5);
//        rightFront.setPower(0.5);
//        rightRear.setPower(0.5);
//    }
//    private void stopMotors(){
//        leftFront.setPower(0);
//        leftRear.setPower(0);
//        rightFront.setPower(0);
//        rightRear.setPower(0);
//    }
//
//    @Override
//    public void runOpMode() {
//        leftFront = hardwareMap.get(DcMotor.class, "leftMotor");
//        rightFront = hardwareMap.get(DcMotor.class, "rightMotor");
//        leftRear = hardwareMap.get(DcMotor.class, "leftBack");
//        rightRear = hardwareMap.get(DcMotor.class, "rightBack");
//        imu = hardwareMap.get(IMU.class, "imu");
//        intake = new intake(hardwareMap, telemetry);
//        //arm = new Arm(hardwareMap, telemetry);
//        timer = new ElapsedTime();
//
//        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
//        leftRear.setDirection(DcMotorSimple.Direction.FORWARD);
//        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
//        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);
//
//        waitForStart();
//
//        //elevatorPControl.updateBySetPoint();
//        timer.reset();
//
//        startMotors();
//
//        sleep(400);
//
//        stopMotors();
//
//
//        sleep(500);
//
//        //timer.reset();
//        //while (timer.milliseconds() < 200) {
//            //arm.armSetPower(0.8);
//        //}
//
//        //arm.armSetPower(0);
//
//
////            sleep(200);
//
//
////            sleep(29100);
//
////            intake.spitOutGamePiece();
////
////            sleep(700);
////
////            leftFront.setPower(-0.7);
////            leftRear.setPower(0.7);
////            rightFront.setPower(0.7);
////            rightRear.setPower(-0.7);
////
////            sleep(150);
////
////            leftFront.setPower(0);
////            leftRear.setPower(0);
////            rightFront.setPower(0);
////            rightRear.setPower(0);
////
////            sleep(200);
////
////            startMotors();
////
////            sleep(1500);
////
////            stopMotors();
////
////            sleep(100);
////
////            leftFront.setPower(0.7);
////            leftRear.setPower(-0.7);
////            rightFront.setPower(0.7);
////            rightRear.setPower(-0.7);
////
////            sleep(500);
////
////            stopMotors();
////
////            sleep(15000);
//        while (opModeIsActive());
//    }
//}