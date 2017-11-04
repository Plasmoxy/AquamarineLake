package gui;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame
{
    public MainPanel panel = new MainPanel();

    public GUI()
    {
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("SwingingRopeA");
        
        //--
        add(BorderLayout.CENTER, panel);
        pack();
        //--
        
        setVisible(true);
    }

    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e){e.printStackTrace();}
        
        GUI gui = new GUI();
    }

}
