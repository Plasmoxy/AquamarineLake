import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class DrawPanel extends JPanel
{
    public Color BGCOLOR = Color.black, BALLCOLOR = Color.red;
    
    public int WIDTH=0, HEIGHT=0, ballx=0, bally=0, ballSize=30, mousex=0, mousey=0;
    
    private boolean ballinit = false;
    
    Random rnd = new Random();
    
    public DrawPanel()
    {
        setBackground(BGCOLOR);
        
        addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                if (mousex > ballx && mousex < ballx+ballSize && mousey > bally && mousey < mousey+ballSize)
                {
                    newBall();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {

            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });
        
    }
    
    public void paintComponent(Graphics g) // executes on each frame
    {
        super.paintComponent(g);
        //Graphics2D g2d = (Graphics2D) g;
        
        updateSize();
        updateMouse();
        drawBG(g);
        
        drawBall(g);
        
        //draw mouse cursor
        g.setColor(Color.white);
        g.drawOval(mousex-3, mousey-3, 6, 6);
    }
    
    public void updateSize()
    {
        HEIGHT = getHeight();
        WIDTH = getWidth();
    }
    
    public void drawBG(Graphics g)
    {
        Color colorBefore = g.getColor();
        g.setColor(BGCOLOR);
        g.fillRect(0,0,WIDTH,HEIGHT);
        g.setColor(colorBefore);
    }
    
    public void newBall()
    {
        try
        {
            ballx = rnd.nextInt(WIDTH - 2 * ballSize) + ballSize;
            bally = rnd.nextInt(HEIGHT - 2 * ballSize) + ballSize;
        }catch (Exception e ) {}
    }
    
    public void drawBall(Graphics g)
    {
        g.setColor(BALLCOLOR);
        g.fillOval(ballx,bally,ballSize,ballSize);
    }
    
    public void updateMouse()
    {
        mousex = getMousePosition().x;
        mousey = getMousePosition().y;
    }
    
}
