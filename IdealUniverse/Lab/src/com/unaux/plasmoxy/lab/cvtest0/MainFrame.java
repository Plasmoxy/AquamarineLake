package com.unaux.plasmoxy.lab.cvtest0;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainFrame extends JFrame
{

    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME);} // Load opencv natives

    public PaintPanel p;

    public MainFrame()
    {

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        p = new PaintPanel();
        add(p);
        pack();

        setVisible(true);
    }

    public static void main(String[] args)
    {
        MainFrame f = new MainFrame();

        VideoCapture cap = new VideoCapture(0);

        f.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);
                cap.release();
                System.exit(0);
            }
        });

        Mat frame = new Mat();

        while(cap.read(frame)) {
            f.p.setImage(f.Mat2BufferedImage(frame));
            f.p.repaint();
        }


    }

    public BufferedImage Mat2BufferedImage(Mat m){
        //source: http://answers.opencv.org/question/10344/opencv-java-load-image-to-gui/
        //Fastest code
        //The output can be assigned either to a BufferedImage or to an Image

        int type = BufferedImage.TYPE_BYTE_GRAY;
        if ( m.channels() > 1 ) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = m.channels()*m.cols()*m.rows();
        byte [] b = new byte[bufferSize];
        m.get(0,0,b); // get all the pixels
        BufferedImage image = new BufferedImage(m.cols(),m.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(b, 0, targetPixels, 0, b.length);
        return image;
    }
}
