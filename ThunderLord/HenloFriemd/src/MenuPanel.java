import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel
{
    private JButton buttonExit = new JButton("EXIT");
    
    public MenuPanel()
    {
        setPreferredSize(new Dimension(MainPanel.INITSIZE.width, 50));
        setBackground(Color.cyan);
        
        buttonExit.addActionListener((ActionEvent e) -> {
            GUI.window.closeWindow();
        });
        add(buttonExit);
    }
}
