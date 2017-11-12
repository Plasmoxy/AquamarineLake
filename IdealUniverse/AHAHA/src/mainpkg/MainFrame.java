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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    private volatile VideoCapture cap;
    private volatile Mat frame;

    public volatile DrawPanel p;

    public MainFrame()
    {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setTitle("OPENCV3.3.0 AHAHAHAH by Plasmoxy");

        setPreferredSize(new Dimension(640, 480));

        cap = new VideoCapture(0);
        frame = new Mat();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                cap.release();
                System.out.println("Successfully closed the MainFrame.");
                System.exit(0);
            }
        });

        addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                super.keyPressed(e);
                if (e.getKeyChar() == 'q' || e.getKeyCode() == KeyEvent.VK_ESCAPE)
                {
                    closeWindow();
                }
            }
        });

        p = new DrawPanel();
        add(p);
        
        p.setFrame(frame);

        pack();

        setVisible(true);
    }

    public void updateFrame()
    {
        cap.read(frame);
        Imgproc.rectangle(frame, new Point(50, 50), new Point(100, 100), new Scalar(0,0,255), -1);
        p.repaint();
    }

    public Scalar hsvBgrScalar(double H, double S, double V) {
        Mat rgb = new Mat();
        Mat hsv = new Mat(1, 1, CvType.CV_8UC3, new Scalar(H, S, V));

        Imgproc.cvtColor(hsv, rgb, Imgproc.COLOR_HSV2BGR);

        int size = (int) (rgb.total() * rgb.channels());

        byte[] data = new byte[size];

        rgb.get(0,0,data);

        return new Scalar(data[0], data[1], data[2]);
    }

    public void closeWindow()
    {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

}
