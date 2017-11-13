import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class DrawPanel extends JPanel
{
    public volatile Color BGCOLOR = Color.black, ballColor = Color.red;
    
    public int WIDTH=0, HEIGHT=0, ballx=0, bally=0, ballSize=80, mousex=0, mousey=0;
    
    public int ballsClicked = 0;
    
    private boolean renderActive = false;
    
    private boolean loading = true;
    
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
                // advanced circle inequation recognition
                if ( Math.pow(mousex-ballx, 2) + Math.pow(mousey-bally, 2) <= Math.pow(ballSize, 2)/4)
                {
                    ballsClicked++;
                    newBall();
                }
                    
                /* simple box recognition    
                if (mousex > ballx && mousex < ballx+ballSize && mousey > bally && mousey < bally+ballSize)
                {
                    newBall();
                }
                */
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
    
    public void init() // has to be called from outside, the panel will then have size and stuff
    {
        updateSize();
        updateMouse();
        newBall();
        loading = false;
        setRenderActive(true);
    }
    
    public void setRenderActive(boolean active)
    {
        renderActive = active;
    }
    
    public void setBallColor(Color c)
    {
        ballColor = c;
    }
    
    public void paintComponent(Graphics g) // executes on each frame
    {
        super.paintComponent(g);
        //Graphics2D g2d = (Graphics2D) g;
        
        if (loading)
        {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            g.setColor(Color.white);
            g.drawString("LOADING BITCH ...",WIDTH,HEIGHT);
        }
        
        if (!renderActive) return;
        
        updateSize();
        updateMouse();
        drawBG(g);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 70));
        g.setColor(ballColor);
        g.drawString("BALLZ CLICCED XD : "+String.valueOf(ballsClicked),50,70);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.setColor(Color.white);
        g.drawString("EPILEPTIC BALL CLICKER GAME - by Seb Petrik (Plasmoxy)",70,getHeight()-40);
        
        drawBall(g);

        //draw mouse cursor
        g.setColor(Color.white);
        g.drawOval(mousex-3, mousey-3, 6, 6);
    }
    
    public void updateSize() // dynamic panel sizing
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
            ballSize = rnd.nextInt(200-30)+30;
            ballx = rnd.nextInt(WIDTH - 2 * ballSize) + ballSize;
            bally = rnd.nextInt(HEIGHT - 2 * ballSize) + ballSize;
        }catch (Exception e ) {}
    }
    
    public void drawBall(Graphics g)
    {
        g.setColor(ballColor);
        g.fillOval(ballx-ballSize/2,bally-ballSize/2,ballSize,ballSize);
    }
    
    public void updateMouse()
    {
        try
        {
            mousex = getMousePosition().x;
            mousey = getMousePosition().y;
        } catch(NullPointerException e) {}
    }

    public static Color hsvToRgbColor(float hue, float saturation, float value) {

        int h = (int)(hue * 6);
        int f = (int) ( hue * 6 - h );
        int p = (int) (value * (1 - saturation));
        int q = (int) (value * (1 - f * saturation));
        int t = (int) (value * (1 - (1 - f) * saturation));

        switch (h) {
            case 0: return new Color(value, t, p);
            case 1: return new Color(q, value, p);
            case 2: return new Color(p, value, t);
            case 3: return new Color(p, q, value);
            case 4: return new Color(t, p, value);
            case 5: return new Color(value, p, q);
            default: throw new RuntimeException("Something went wrong when converting from HSV to RGB. Input was " + hue + ", " + saturation + ", " + value);
        }
    }
    
}
