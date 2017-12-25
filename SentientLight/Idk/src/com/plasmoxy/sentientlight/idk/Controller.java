package com.plasmoxy.sentientlight.idk;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Controller implements Initializable
{
    
    // NODES
    @FXML JFXButton cameraButton;
    @FXML ImageView imageView;
    @FXML JFXToggleButton grayscaleToggle;
    @FXML JFXToggleButton thenkToggle;
    
    // OpenCV
    
    private VideoCapture cap = new VideoCapture();
    private boolean cameraActive = false;
    private static int cameraId = 0;

    private ScheduledExecutorService timer;
    private Runnable frameGrabber = () -> {
        Mat frame = grabFrame();
        CVUtility.onFXThread(imageView.imageProperty(), CVUtility.mat2Image(frame));
    };
    
    // CUSTOM
	
	Mat thenkMat;
    
    // Handling methods
    
    @FXML
    protected void startCamera(ActionEvent event)
    {
        if (!cameraActive)
        {
            cap.open(cameraId);
            if (cap.isOpened())
            {
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
    
    @FXML
	protected void loadThenk(ActionEvent event)
	{
		if (thenkToggle.isSelected()) this.thenkMat = Imgcodecs.imread("res/thenk.png");
	}
    
    // cv methods
    private Mat grabFrame()
    {
        Mat frame = new Mat(); // empty mat
        if (cap.isOpened())
        {
            try
            {
                cap.read(frame);
                if (!frame.empty()) process(frame);
            }
            catch(Exception ex)
            {
                System.err.println("Error during image processing.");
            }
        }
        
        return frame;
    }
    
    private void stopAcquisition()
    {
        if (timer!=null && !timer.isShutdown())
        {
            try
            {
                timer.shutdown();
                timer.awaitTermination(33, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {e.printStackTrace();}
        }
        
        if (cap.isOpened()) cap.release();
    }
    
    // process the frame here
    
    private void process(Mat f)
    {
    	// grayscale toggle
        if (grayscaleToggle.isSelected()) Imgproc.cvtColor(f, f, Imgproc.COLOR_BGR2GRAY);
        
        // add image to frame
		if (thenkToggle.isSelected() && thenkMat != null)
		{
			Rect roi = new Rect(f.cols()-thenkMat.cols(), f.rows()-thenkMat.rows(), thenkMat.cols(), thenkMat.rows());
			Mat thenkROI = f.submat(roi);

			Core.addWeighted(thenkROI, 1.0, thenkMat, 1.0, 0.0, thenkROI);
		}
		
    }
    
    // controller methods
    
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        
    }
    
    protected void close()
    {
        stopAcquisition();
    }
    
}
