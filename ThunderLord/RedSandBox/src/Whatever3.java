public class Whatever3
{
    
    class A
    {
        private int val;
        
        public A(int v) {val=v;}
        public synchronized void set(int v) {val = v;}
        public synchronized int get() {return val;}
        public synchronized void print()
        {
            System.out.println(val);
        }
    }
    
    public A a = new A(0);
    
    Runnable printa = () ->
    {
        for (;;)
        {
            a.print();
            try {Thread.sleep(500);} catch(InterruptedException e) {}
        }
    };
    
    Runnable change = () ->
    {
        for (;;)
        {
            int chg = (int) (Math.random() * 20);
            System.out.println("[Change] " + chg);
            a.set(chg);
            try {Thread.sleep(500);} catch(InterruptedException e) {}
        }
    };
    
    public Whatever3()
    {
        Thread ta = new Thread(printa);
        Thread tb = new Thread(change);
        
        ta.start();
        tb.start();
    }
    
    public static void main(String[] args)
    {
        Whatever3 w = new Whatever3();
    }
}
