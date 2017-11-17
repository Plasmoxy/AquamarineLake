package swingSandAlpha;

public class Main
{
    public static GUI window = new GUI();
    
    public static volatile boolean colorUpdateActive = true;
    public static Runnable colorUpdate = () ->
    {
        while (colorUpdateActive)
        {
            window.mp.refresh();
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
            }
        }
    };
    public static Thread colorUpdater = new Thread(colorUpdate);

    public static void main(String[] args)
    {
        colorUpdater.start();
    }
    
}
