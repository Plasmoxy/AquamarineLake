import javafx.scene.control.Slider;
import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import plasmoxycvutil.CVUtility;

import javax.swing.*;
import java.awt.*;


public class DrawPanel extends JPanel
{
    public volatile Mat drawMat;
    public VideoCapture cap = new VideoCapture(0);
    
    public volatile int iLowH = 0, iHighH = 179, iLowS = 50, iHighS = 255,
        iLowV = 35, iHighV = 255, morphScale = 5, minSize = 30;
    
    
    public DrawPanel()
    {
        setPreferredSize(new Dimension(640, 480));
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (drawMat != null) if ( !drawMat.empty() )
                    g.drawImage(CVUtility.matToBufferedImage(drawMat), 0, 0, null);
    }
    
    public void updateColors()
    {
        SliderPanel sp = Main.window.sliderPanel;
        iHighH = sp.sliderHighH.getValue();
        iHighS = sp.sliderHighS.getValue();
        iHighV = sp.sliderHighV.getValue();
        iLowH = sp.sliderLowH.getValue();
        iLowS = sp.sliderLowS.getValue();
        iLowV = sp.sliderLowV.getValue();
    }
    
    public void refresh()
    {
        updateColors();
        
        Mat frame = new Mat(), imageHSV = new Mat(), imgMasked = new Mat(), mask = new Mat();
        
        cap.read(frame);
        
        Imgproc.cvtColor(frame, imageHSV, Imgproc.COLOR_BGR2HSV);
        Core.inRange(imageHSV, new Scalar(iLowH, iLowS, iLowV), new Scalar(iHighH, iHighS, iHighV), mask);
        
        Imgproc.erode(mask, mask, Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(morphScale, morphScale)));
        Imgproc.dilate(mask, mask, Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(morphScale, morphScale)));
        
        Imgproc.erode(mask, mask, Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(morphScale, morphScale)));
        Imgproc.dilate(mask, mask, Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(morphScale, morphScale)));
        
        
        frame.copyTo(imgMasked, mask);
        
        drawMat = imgMasked;
        
        repaint();
    }
}
