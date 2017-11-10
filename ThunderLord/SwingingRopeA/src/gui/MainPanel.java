package gui;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel
{
    public ContentStuffPanel stuff = new ContentStuffPanel();
    
    public SuperButton b1 = new SuperButton("XD LAMOAMDOASD"), b2 = new SuperButton("ASD");

    public MainPanel()
    {
        super(new BorderLayout());
        setPreferredSize(new Dimension(400, 300));
        setBackground(Color.red);
        
        //--
        add(b1, BorderLayout.NORTH);
        //--

    }

}