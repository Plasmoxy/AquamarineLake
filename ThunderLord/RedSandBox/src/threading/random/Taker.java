package threading.random;

public class Taker implements Runnable
{
    
    private Main main;
    
    public Taker(Main m)
    {
        main = m;
    }
    
    @Override
    public void run()
    {
        System.out.println("[Taker] starting");
        System.out.println("[Taker] notifying");
        System.out.println("RANDOM -> " + main.giver.r);
        main.giver.notify();
        
        
    }
}
