package mainpkg;

import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.utils.Converters;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    private volatile VideoCapture cap;
    private volatile Mat frame;

    public volatile DrawPanel p;

    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    public MainFrame()
    {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        setPreferredSize(new Dimension(640, 480));

        cap = new VideoCapture(0);
        frame = new Mat();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                cap.release();
                System.exit(0);
            }
        });

        p = new DrawPanel();
        add(p);

        pack();

        setVisible(true);
    }

    public void updateFrame()
    {//ll
        cap.read(frame);

        Imgproc.rectangle(frame, new Rect(0, 0, 100, 100), hsvBgrScalar(iLowH, iLowS, iLowV), -1);
        Imgproc.rectangle(frame, new Rect(100, 0, 100, 100), hsvBgrScalar(iHighH, iHighS, iHighV), -1);

        Imgproc.rectangle(frame, Rect(0,100,100,100), hsvBgrScalar(iLowH, 255, 255), -1);
        Imgproc.rectangle(frame, Rect(100,100,100,100), hsvBgrScalar(iHighH, 255, 255), -1);

        Imgproc.putText(frame, "MIN", new Point(0, 20), CV_FONT_HERSHEY_SIMPLEX, 0.7, Scalar(255, 255, 255), 1);
        Imgproc.putText(frame, "MAX", Point(100, 20), CV_FONT_HERSHEY_SIMPLEX, 0.7, Scalar(255, 255, 255), 1);

        Imgproc.putText(frame, "MIN_HUE", Point(0, 120), CV_FONT_HERSHEY_SIMPLEX, 0.7, Scalar(255, 255, 255), 1);
        Imgproc.putText(frame, "MAX_HUE", Point(100, 120), CV_FONT_HERSHEY_SIMPLEX, 0.7, Scalar(255, 255, 255), 1);

        p.setFrame(frame);
        p.repaint();
    }

    public Scalar hsvBgrScalar(double H, double S, double V) {
        Mat rgb;
        Mat hsv(1, 1, CvType.CV_8UC3, new Scalar(H, S, V));
        Imgproc.cvtColor(hsv, rgb, Imgproc.CV_HSV2BGR);
        return Scalar(rgb.data[0], rgb.data[1], rgb.data[2]);
    }

}
