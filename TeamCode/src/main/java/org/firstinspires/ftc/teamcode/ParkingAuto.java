package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.teamcode.intake;



import org.firstinspires.ftc.robotcore.external.Telemetry;
//@Autonomous(name = "ParkingAuto", group = "Examples")
//public class ParkingAuto extends LinearOpMode {
//    private DcMotor leftFront;
//    private DcMotor rightFront;
//    private DcMotor leftRear;
//    private DcMotor rightRear;
//    private IMU imu;
//    private intake intake;
//    private Telemetry telemetry;
//
//    private void startMotors() {
//        leftFront.setPower(1);
//        leftRear.setPower(1);
//        rightFront.setPower(1);
//        rightRear.setPower(1);
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
//
//        waitForStart();
//
//        while (opModeIsActive()) {
//            //elevatorPControl.updateBySetPoint();
//            leftFront.setPower(-0.7);
//            leftRear.setPower(0.7);
//            rightFront.setPower(-0.7);
//            rightRear.setPower(0.7);
//
//            sleep(900);
//
//            leftFront.setPower(0);
//            leftRear.setPower(0);
//            rightFront.setPower(0);
//            rightRear.setPower(0);
//
//            sleep(29300);
//        }
//    }
//}
