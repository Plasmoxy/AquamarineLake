public class Main
{
    public static volatile GUI window;
    public static volatile Thread mainRenderer;
    
    private static Runnable render = () -> {
            long stamp;
            for (;;)
            {
                window.dp.repaint();
            }
    };

    public static void main(String[] args)
    {
        window = new GUI();
        mainRenderer = new Thread(render);
        mainRenderer.start();
    }
}
