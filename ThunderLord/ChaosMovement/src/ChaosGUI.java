import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ChaosGUI extends JFrame
{

    public int x;
    public int y;
    public DrawPanel dpanel;
    public final int BALLSIZE = 30;

    public static final Color bgColor = new Color(10,10,10);
    public static final Color ballColor = new Color(28, 255, 213);

    public Random rnd;

    class DrawPanel extends JPanel
    {

        public DrawPanel()
        {
            setPreferredSize(new Dimension(800, 500));
        }

        @Override
        public void paintComponent(Graphics g)
        {
            g.setColor(bgColor);
            g.fillRect(0,0,getWidth(),getHeight());
            g.setColor(ballColor);
            g.fillOval(x,y,BALLSIZE, BALLSIZE);
        }
    }

    public void animate()
    {
        try {
            int xadd=1, yadd=1;
            final int mvBound = 5;
            for (;;) {

                if ( x+BALLSIZE >= dpanel.getWidth()) xadd=-1*(rnd.nextInt(mvBound)+1);
                if ( y+BALLSIZE >= dpanel.getHeight()) yadd=-1*(rnd.nextInt(mvBound)+1);
                if ( x <= 0) xadd=rnd.nextInt(mvBound)+1;
                if ( y <= 0) yadd=rnd.nextInt(mvBound)+1;

                x+=xadd;
                y+=yadd;

                dpanel.repaint();

                Thread.sleep(5);
            }
        }catch (InterruptedException e) {e.printStackTrace();}
    }

    public void closeWindow()
    {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    public ChaosGUI()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Plasmoxy | Chaos Movement | Window is responsive, resize it ! xD");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        setCursor( getToolkit().createCustomCursor(
                new BufferedImage( 1, 1, BufferedImage.TYPE_INT_ARGB ),
                new Point(),
                null ) );

        rnd = new Random();

        x = rnd.nextInt(500-1)+1;
        y = rnd.nextInt(800-1)+1;

        dpanel = new DrawPanel();
        add(BorderLayout.CENTER, dpanel);

        addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e)
            {
                closeWindow();
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e)
            {
                closeWindow();
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        pack();
        setVisible(true);
    }

    public static void main(String[] args)
    {
        ChaosGUI gui = new ChaosGUI();
        gui.animate();
    }
}
