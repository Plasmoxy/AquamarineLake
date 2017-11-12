import org.opencv.core.Core;

public class Main
{
    
    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }
    
    public static volatile GUI window = new GUI();
    public static volatile Thread mainRenderer;

    public static void main(String[] args)
    {
        Runnable render = () -> {
            for (;;)
            {
                window.dp.refresh();
            }
        };
        
        mainRenderer = new Thread(render);
        mainRenderer.start();
        System.out.println("Started render thread.");
    }
    
}