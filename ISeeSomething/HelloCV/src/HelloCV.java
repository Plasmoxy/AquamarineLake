import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class HelloCV
{
	public static void main(String[] args)
	{
		System.out.println("Hello, OpenCV");
	    // Load the native library.
	    System.loadLibrary("opencv_java244");

	    VideoCapture camera = new VideoCapture(0);
	    camera.open(0); //Useless
	    if(!camera.isOpened()){
	        System.out.println("Camera Error");
	    }
	    else{
	        System.out.println("Camera OK?");
	    }

	    Mat frame = new Mat();

	    //camera.grab();
	    //System.out.println("Frame Grabbed");
	    //camera.retrieve(frame);
	    //System.out.println("Frame Decoded");

	    camera.read(frame);
	    System.out.println("Frame Obtained");

	    /* No difference
	    camera.release();
	    */

	    System.out.println("Captured Frame Width " + frame.width());

	    Imgcodecs.imwrite("camera.jpg", frame);
	    System.out.println("OK");
	}
}
