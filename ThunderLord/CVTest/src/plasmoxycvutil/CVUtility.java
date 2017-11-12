package plasmoxycvutil;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

// CVUtility Version 0.1
public class CVUtility
{
    public static Image matToBufferedImage(Mat m)
    {
        // just a simple convertor from web, this code is the fastest one
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if ( m.channels() > 1 ) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = m.channels()*m.cols()*m.rows();
        byte [] b = new byte[bufferSize];
        m.get(0,0,b);
        BufferedImage image = new BufferedImage(m.cols(),m.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(b, 0, targetPixels, 0, b.length);
        return image;
        
    }
    
    public static Scalar hsvToBgrScalar(Scalar hsvin)
    {
        Mat bgr = new Mat();
        Mat hsv = new Mat(1, 1, CvType.CV_8UC3, hsvin);
        Imgproc.cvtColor(hsv, bgr, Imgproc.COLOR_HSV2BGR);
        byte[] bgr_data = new byte[(int)(bgr.total() * bgr.channels())];
        bgr.get(0,0, bgr_data);
        return new Scalar(bgr_data[0], bgr_data[1], bgr_data[2]);
    }
    
}
