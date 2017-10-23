package mainpkg;

import org.opencv.core.Core;
import org.opencv.core.Mat;

public class Main
{
    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    public static volatile MainFrame window;


    public static void main(String[] args)
    {
        window = new MainFrame();


        System.out.println("Starting render control thread.");

        Runnable fpsTest = () -> {
            long stamp = 0;
            for(int i = 0;i < 10; i++)
            {
                stamp = System.nanoTime();
                window.updateFrame();
                System.out.println( ( Math.pow(10,9)/( System.nanoTime()-stamp)  ) );

            }
            System.out.println(" FINISHED THREAD NOW CLOSING ");
            window.closeWindow();
        };

        Runnable render = () -> {
            for(;;)
            {
                window.updateFrame();
            }
        };

        Thread mainRenderer = new Thread(render);

        mainRenderer.start();

    }

}
