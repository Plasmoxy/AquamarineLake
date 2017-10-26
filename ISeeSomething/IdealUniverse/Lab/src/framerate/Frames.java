package framerate;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class Frames {
    private VideoCapture videoCapture;
    private boolean isOpened;
    private boolean isSucceed;

    public Frames() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        videoCapture = null;
        isOpened = false;
        isSucceed = false;
    }

    public void grabImage(){
        Mat frame = new Mat();

        //connect
        videoCapture = new VideoCapture(0);
        isOpened = videoCapture.isOpened();
        System.out.println("connected: " + isOpened);
        //setSetting
        videoCapture.set(Videoio.CV_CAP_PROP_FRAME_WIDTH, 1280);
        videoCapture.set(Videoio.CV_CAP_PROP_FRAME_HEIGHT, 720);
        //startGrab
        isSucceed = videoCapture.grab();
        System.out.println("started: " + String.valueOf(isSucceed));
        if ((!isOpened) || (!isSucceed))
            return;
        System.out.println("------- START GRAB -------");

        //Wait for camera starting
        while (true){
            videoCapture.read(frame);
            if (!frame.empty())
                break;
        }

        int frameNo = 0;
        long startSysMillis = System.currentTimeMillis();
        while (frameNo < 1000){
            videoCapture.read(frame);
            frameNo++;
        }
        System.out.println(frameNo + " frames in " + (System.currentTimeMillis() - startSysMillis) + " millis");

        videoCapture.release(); // release device

        System.out.println('\n' + "Done");
    }

    public static void main(String[] args) {
        Frames f = new Frames();
        f.grabImage();
    }
}