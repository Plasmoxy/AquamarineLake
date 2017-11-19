package threading.random;

import java.util.Random;

public class Giver implements Runnable
{
    public int r;
    private Random rnd = new Random();
    private Main main;
    
    public boolean active = true;
    
    public Giver(Main m)
    {
        main = m;
    }
    
    @Override
    public void run()
    {
        System.out.println("[Giver] starting");
        rnd.setSeed(System.currentTimeMillis());
        while (active)
        {
            System.out.println("[Giver] generating int");
            r = rnd.nextInt();
            System.out.println("[Giver] waiting");
            try
            {
                wait();
            } catch (InterruptedException e) {}
        }
    }
}
