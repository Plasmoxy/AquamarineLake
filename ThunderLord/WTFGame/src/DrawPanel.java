import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel
{
    public volatile Color BGCOLOR = Color.black;
    
    public DrawPanel()
    {
        
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(BGCOLOR);
        g2d.setColor(Color.white);
        g2d.drawOval(getWidth()/2-10, getHeight()/2-10, 20, 20);
    }
    
}
