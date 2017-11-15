import javax.swing.*;

public class SliderPanel extends JPanel
{
    public volatile JSlider
            sliderLowH = new JSlider(JSlider.HORIZONTAL, 0, 255, 0),
            sliderHighH =  new JSlider(JSlider.HORIZONTAL, 0, 255, 179),
            sliderLowS = new JSlider(JSlider.HORIZONTAL, 0, 255, 50),
            sliderHighS =  new JSlider(JSlider.HORIZONTAL, 0, 255, 255),
            sliderLowV = new JSlider(JSlider.HORIZONTAL, 0, 255, 35),
            sliderHighV =  new JSlider(JSlider.HORIZONTAL, 0, 255, 255);
    
    
    public SliderPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        
        add(new JLabel("sliders :: LowH-HighH LowS-HighS LowV-HighV"));
        add(sliderLowH);
        add(sliderHighH);
        add(sliderLowS);
        add(sliderHighS);
        add(sliderLowV);
        add(sliderHighV);
    }
}
