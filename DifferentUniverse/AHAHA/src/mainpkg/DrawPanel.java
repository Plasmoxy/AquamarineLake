package mainpkg;

import org.opencv.core.Mat;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;


public class DrawPanel extends JPanel {

    private volatile Mat frame;

    public DrawPanel()
    {

    }

    public void setFrame(Mat m)
    {
        frame = m;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(bufferedImage(frame), 0, 0, null);
    }

    public BufferedImage bufferedImage(Mat m) {


        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (m.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);

        m.get(0, 0, ((DataBufferByte)image.getRaster().getDataBuffer()).getData());
        return image;

    }

}
