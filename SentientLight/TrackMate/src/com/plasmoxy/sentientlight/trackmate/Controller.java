package com.plasmoxy.sentientlight.trackmate;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import org.opencv.core.Mat;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import javax.xml.bind.annotation.XmlList;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Controller {

    // FIELDS --- NODES ---
    @FXML
    JFXButton cameraButton;
    @FXML
    ImageView imageView;
    @FXML
    JFXToggleButton detectFaceToggle;

    // FIELDS --- OpenCV ---

    private VideoCapture cap;
    private boolean cameraActive = false;
    private static int cameraId = 0;

    private ScheduledExecutorService timer;
    private Runnable frameGrabber = () -> {
        Mat frame = grabFrame();
        CVUtility.onFXThread(imageView.imageProperty(), CVUtility.mat2Image(frame));
    };

    // FIELDS  --- OTHER STUFF ---

    CascadeClassifier faceCascade;
    private int absoluteFaceSize; // minimal face size

    private boolean detectFaceActive;

    // METHODS --- CONTROLLER METHODS ---

    public void close() {
        stopAcquisition();
    }

    public void init() {
        System.out.println("INIT");

        cap = new VideoCapture();
        faceCascade = new CascadeClassifier();

        imageView.setFitWidth(640);
        imageView.setPreserveRatio(true);
        
        faceCascade.load("res/haarcascade_frontalface_alt.xml");
    }

    // METHODS --- Handling ---

    @FXML
    protected void detectFaceAction(ActionEvent e) {
        detectFaceActive = detectFaceToggle.isSelected();
    }

    @FXML
    protected void startCamera(ActionEvent event) {
        if (!cameraActive) {
            cap.open(cameraId);
            if (cap.isOpened()) {
                cameraActive = true;
                timer = Executors.newSingleThreadScheduledExecutor();
                timer.scheduleAtFixedRate(frameGrabber, 0, 33, TimeUnit.MILLISECONDS);

                cameraButton.setText("Stop Camera");
            } else {
                System.err.println("Cant open camera");
                cameraButton.setText("ERROR");
            }
        } else {
            cameraActive = false;
            cameraButton.setText("Start Camera");
            stopAcquisition();
        }
    }

    // METHODS -- CV --

    private Mat grabFrame() {
        Mat frame = new Mat(); // empty mat
        if (cap.isOpened()) {
            try {
                cap.read(frame);
                if (!frame.empty()) process(frame);
            } catch (Exception ex) {
                System.err.println("Error during image processing.");
            }
        }

        return frame;
    }

    private void stopAcquisition() {
        if (timer != null && !timer.isShutdown()) {
            try {
                timer.shutdown();
                timer.awaitTermination(33, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (cap.isOpened()) cap.release();
    }

    // process the frame
    private void process(Mat f) {
        if (detectFaceActive) System.out.println("ASDASD");
    }

}
