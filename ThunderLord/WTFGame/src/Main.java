import java.awt.*;
import java.util.Random;

public class Main
{
    public static volatile GUI window;
    public static volatile Thread mainRenderer, colorChanger;
    public static Random rnd = new Random();
    
    private static Runnable render = () -> {
            long stamp;
            while (window.dp.getHeight() == 0) {
                try {Thread.sleep(20);}catch(InterruptedException e) {}
            } // hang thread until getting size

            window.dp.init();
            
            for (;;)
            {
                window.dp.repaint();
            }
    };
    
    private static Runnable colorChange = () ->
    {
        for (; ; )
        {
            try
            {
                window.dp.setBallColor(new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args)
    {
        window = new GUI();
        
        mainRenderer = new Thread(render);
        mainRenderer.start();
        
        colorChanger = new Thread(colorChange);
        colorChanger.start();
        
    }
}
