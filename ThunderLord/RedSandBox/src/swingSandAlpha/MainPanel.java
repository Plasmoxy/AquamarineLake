package swingSandAlpha;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel
{
    public JPanel midPanel = new JPanel();
    
    public JLabel sliderRedLabel = new JLabel();
    public JLabel sliderGreenLabel = new JLabel();
    public JLabel sliderBlueLabel = new JLabel();
    
    public JSlider sliderRed = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
    public JSlider sliderGreen = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
    public JSlider sliderBlue = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
    
    public MainPanel()
    {
        setPreferredSize(new Dimension(500, 400));
        refresh();
        //setLayout(new BorderLayout());W
        
        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));
        midPanel.add(sliderRedLabel);
        midPanel.add(sliderRed);
        midPanel.add(sliderGreenLabel);
        midPanel.add(sliderGreen);
        midPanel.add(sliderBlueLabel);
        midPanel.add(sliderBlue);
        
        add(midPanel);
    }
    
    public void refresh()
    {
        int red = sliderRed.getValue();
        int green = sliderGreen.getValue();
        int blue = sliderBlue.getValue();
        
        sliderRedLabel.setText("RED = " + Integer.toString(red));
        sliderGreenLabel.setText("GREEN = " + Integer.toString(green));
        sliderBlueLabel.setText("BLUE = " + Integer.toString(blue));

        setBackground(new Color(red, green, blue));
    }
}
