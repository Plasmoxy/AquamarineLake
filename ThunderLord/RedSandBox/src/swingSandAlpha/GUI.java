package swingSandAlpha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame
{
    
    public MainPanel mp = new MainPanel();
    public boolean fullscreen = false;
    
    public GUI()
    {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(true);
        setContentPane(mp);
        setMinimumSize(new Dimension(500, 400));
        setTitle("RedSandBox/swingSandAlpha - COLOR PICC");
        pack();
        setLocationRelativeTo(null);
        
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                Main.colorUpdateActive = false;
                super.windowClosing(e);
                System.exit(0);
            }
        });
        
        setVisible(true);
    }
    
    public void closeWindow()
    {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    public void toggleFullScreen()
    {
        if (!fullscreen) {
            fullscreen = false;
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setUndecorated(true);
        } else {
            fullscreen = true;
            setExtendedState(JFrame.NORMAL);
            setUndecorated(false);
        }
    }
    
}
