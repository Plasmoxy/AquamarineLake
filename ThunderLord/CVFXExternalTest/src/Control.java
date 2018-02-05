import com.plasmoxy.cvfxbase.CVFXController;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class Control extends CVFXController {

    @Override
    protected void init() {
        hideAll();
    }
    
    @Override
    protected void process(Mat f, Mat a, Mat b) {
        f.copyTo(a);
        f.copyTo(b);
        exampleColoredRectangle(f, new Scalar(255, 0, 0));
        exampleColoredRectangle(a, new Scalar(0, 255, 0));
        exampleColoredRectangle(b, new Scalar(0, 0, 255));
    }
    
    private void exampleColoredRectangle(Mat frame, Scalar color) {
        Imgproc.rectangle(frame, new Point(0, 0), new Point(50, 50), color, -1);
    }

}
