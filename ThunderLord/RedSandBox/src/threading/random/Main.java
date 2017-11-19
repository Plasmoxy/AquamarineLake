package threading.random;

public class Main
{
    
    public Giver giver = new Giver(this);
    public Taker taker = new Taker(this);
    
    public Thread givert = new Thread(giver);
    public Thread takert = new Thread(taker);
    
    public Main()
    {
        givert.start();
        takert.start();
    }
    
    public static void main(String[] args)
    {
        Main m = new Main();
    }
}
