package com.unaux.plasmoxy.lab.cvtest0;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PaintPanel extends JPanel
{

    private BufferedImage imag;

    public void setImage(BufferedImage img)
    {
        imag = img;
    }

    public PaintPanel()
    {
        setPreferredSize(new Dimension(640, 480));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(imag, 0, 0, null);
    }

}
