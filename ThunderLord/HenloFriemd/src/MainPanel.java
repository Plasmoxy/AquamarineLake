import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class MainPanel extends JPanel
{
    public MenuPanel menu = new MenuPanel();
    
    public static Dimension INITSIZE = new Dimension(400, 300);
    public MainPanel()
    {
        setPreferredSize(INITSIZE);
        
        add(menu);
    }
    
}
