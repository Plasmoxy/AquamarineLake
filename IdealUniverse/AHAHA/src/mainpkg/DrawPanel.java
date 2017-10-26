package mainpkg;

import org.opencv.core.Mat;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;


public class DrawPanel extends JPanel {

    public volatile Mat frame;
    public volatile BufferedImage img;

    public DrawPanel()
    {
        setPreferredSize(new Dimension(640, 480));
    }

    public void setFrame(Mat m)
    {
        frame = m;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (frame != null)
            g.drawImage(enhancedMatToBufferedImage(frame), 0, 0, null);
    }

    public BufferedImage matToBufferedImage(Mat mat) {

        if (mat.height() > 0 && mat.width() > 0) {
            BufferedImage image = new BufferedImage(mat.width(), mat.height(), BufferedImage.TYPE_3BYTE_BGR);
            WritableRaster raster = image.getRaster();
            DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
            byte[] data = dataBuffer.getData();
            mat.get(0, 0, data);
            return image;
        }
        return null;
    }

    public Image enhancedMatToBufferedImage(Mat m){
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
