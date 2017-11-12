import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends JFrame
{
    public volatile DrawPanel dp = new DrawPanel();
    
    public GUI()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("ThunderLord/CVTest");
        setResizable(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dp.cap.release();
                System.out.println("Successfully closed.");
                System.exit(0);
            }
        });

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
        
        add(dp);
        pack();
        
        setVisible(true);
        
    }

    public void closeWindow()
    {
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
    
    
    
    
}
