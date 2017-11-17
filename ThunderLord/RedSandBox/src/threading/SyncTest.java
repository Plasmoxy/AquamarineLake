package threading;

public class SyncTest
{
    public static int x = 100;
    
    public static void main(String[] args)
    {
        Runnable a = () -> {
            if (x == 100) x-=50;
        };
        
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);

        System.out.println(x);
    }
}
