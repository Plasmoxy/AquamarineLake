import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import plasmoxycvutil.CVUtility;

import javax.swing.*;
import java.awt.*;


public class DrawPanel extends JPanel
{
    public volatile Mat frame = new Mat();
    public volatile VideoCapture cap = new VideoCapture(0);
    
    public DrawPanel()
    {
        setPreferredSize(new Dimension(640, 480));
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (frame != null) if ( !frame.empty() )
                    g.drawImage(CVUtility.matToBufferedImage(frame), 0, 0, null);
    }
    
    public void refresh()
    {
        cap.read(frame);
        
        Imgproc.rectangle(frame, new Point(0,0), new Point(50,50), new Scalar(255, 0, 0), -1);
        
        repaint();
    }
}
