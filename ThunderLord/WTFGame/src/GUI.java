import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class GUI extends JFrame
{
    public volatile DrawPanel dp = new DrawPanel();
    
    public GUI()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        hideDPCursor();
        
        add(dp);
        pack();
        
        addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                super.keyPressed(e);
                if (e.getKeyChar() == 'q' || e.getKeyCode() == KeyEvent.VK_ESCAPE)
                {
                    closeWindow();
                }
            }
        });
        
        setVisible(true);

    }
    
    public void hideDPCursor()
    {
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = getToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        dp.setCursor(blankCursor);
    }
    public void closeWindow()
    {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
}
