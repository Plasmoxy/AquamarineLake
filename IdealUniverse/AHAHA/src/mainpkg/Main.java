package mainpkg;

import org.opencv.core.Mat;

public class Main
{

    public static volatile MainFrame window;


    public static void main(String[] args)
    {
        window = new MainFrame();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    window.updateFrame();
                }
            }
        }).start();
    }

}
