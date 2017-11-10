import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class GUI extends JFrame
{

    public static GUI window;
    
    public MainPanel mp = new MainPanel();
    public GUI()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("HenloFriemd");
        
        add(mp);
        pack();
    }

    public static void main(String[] args)
    {
        window = new GUI();
        window.setVisible(true);
    }
    
    public void closeWindow()
    {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

}
