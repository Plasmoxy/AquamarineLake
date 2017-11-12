import javax.swing.*;

public class GUI extends JFrame
{
    public DrawPanel dp = new DrawPanel();
    
    public GUI()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("ThunderLord/CVTest");
        setResizable(true);
        
        add(dp);
        pack();
        
        setVisible(true);
        
    }

    public static void main(String[] args)
    {
        GUI window = new GUI();
    }
}
