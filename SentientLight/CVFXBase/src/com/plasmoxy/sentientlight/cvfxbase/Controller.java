package com.plasmoxy.sentientlight.cvfxbase;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * Controller class for CVFXBase by Plasmoxy
 */

public class Controller { // control class for gui.fxml

    // FIELDS -- Nodes --
    @FXML JFXButton cameraButton;
    @FXML ImageView imageView; // the biggest imageView
    @FXML ImageView imageViewAlpha; // small upper imageView
    @FXML ImageView imageViewBeta; // small lower imageView

    // FIELDS -- CV --

    private VideoCapture cap;
    private boolean cameraActive = false;
    private int cameraId = 0; // ID OF THE CAMERA

    private boolean renderMainActive = true, renderAlphaActive, renderBetaActive;

    private Mat frame, frameAlpha, frameBeta; // frame fields

    // FIELDS -- Render --

    private ScheduledExecutorService timer;
    private Runnable frameRenderer = () -> {
        frame = grabFrame(); // grab frame from camera

        // if there is a frame to process&show
        if (frame!=null && !frame.empty()) {

            // process frames and update views
            process();
            if ( renderMainActive ) CVUtility.setProperty(imageView.imageProperty(), CVUtility.mat2Image(frame));

            // update alpha and beta views
            if (renderAlphaActive && frameAlpha != null && !frameAlpha.empty())
                CVUtility.setProperty(imageViewAlpha.imageProperty(), CVUtility.mat2Image(frameAlpha));

            if (renderBetaActive && frameBeta != null && !frameAlpha.empty())
                CVUtility.setProperty(imageViewBeta.imageProperty(), CVUtility.mat2Image(frameBeta));

        }


    };

    // METHODS -- CONTROLLER --

    public void init() { // external
        System.out.print("[Controller] Initializing controler");
        cap = new VideoCapture();

        // fix imageViews so they don't resize
        imageView.setFitWidth(640);
        imageView.setPreserveRatio(true);
        imageViewAlpha.setFitWidth(320);
        imageViewAlpha.setPreserveRatio(true);
        imageViewBeta.setFitWidth(320);
        imageViewBeta.setPreserveRatio(true);

    }

    protected void close() { // external
        stopRendering();
    }

    // METHODS -- FXML --

    @FXML
    protected void startCamera(ActionEvent event) {
        if (!cameraActive) {
            cap.open(cameraId);

            if (cap.isOpened()) {
                cameraActive = true;
                startRendering();
                cameraButton.setText("Stop Camera");
            } else {
                System.err.println("Cant open camera");
                cameraButton.setText("ERROR");
            }

        } else {
            cameraActive = false;
            cameraButton.setText("Start Camera");
            stopRendering();
        }
    }

    // METHODS -- CV --

    // grab mat from video capture
    private Mat grabFrame() {
        Mat frame = new Mat(); // empty mat
        if (cap.isOpened()) {
            try {
                cap.read(frame);
            } catch (Exception ex) {
                System.err.println("[CV] Error during image processing.");
            }
        }
        return frame;
    }

    private void startRendering() {
        timer = Executors.newSingleThreadScheduledExecutor();
        timer.scheduleAtFixedRate(frameRenderer, 0, 33, TimeUnit.MILLISECONDS);
    }

    private void stopRendering() {
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

    // process the frame here
    // frames - imageView, imageViewAlpha, imageViewBeta
    private void process() {



    }

}
