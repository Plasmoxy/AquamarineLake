package swingSandBeta;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame
{
    public MainPanel mp = new MainPanel();
    
    public GUI()
    {
        setDefaultCloseOperation(3);
        setMinimumSize(new Dimension(300, 200));
        setSize(300, 200);
        setLocationRelativeTo(null);

        getContentPane().add(mp);

        setVisible(true);
    }
}
