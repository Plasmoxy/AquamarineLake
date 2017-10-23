package mainpkg;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {

    public volatile VideoCapture cap;
    public volatile DrawPanel p;
    public static volatile MainFrame window;

    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    public MainFrame()
    {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new Dimension(640, 480));

        cap = new VideoCapture(0);

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

    public static void main(String[] args)
    {

        window = new MainFrame();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Mat frame = new Mat();
                while (true)
                {
                    window.cap.read(frame);
                    window.p.setFrame(frame);
                    window.p.repaint();
                }
            }
        }).start();
    }

}
