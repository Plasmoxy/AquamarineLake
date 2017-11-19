public class Whatever2
{

    static class Overseer<T>
    {
        private T t;
        
        public Overseer(T var)
        {
            t = var;
        }
        
        public T get()
        {
            return t;
        }
        
        public void set(T var)
        {
            t = var;
        }
        
        @Override
        public String toString()
        {
            return t.toString();
        }
    }
    
    static <T> void swap(Overseer<T> a, Overseer<T> b)
    {
        T temp = a.get();
        a.set(b.get());
        b.set(temp);
    }
    
    public static void main(String[] args)
    {
        Overseer<Integer> a = new Overseer<Integer>(new Integer(3));
        Overseer<Integer> b = new Overseer<Integer>(new Integer(5));

        System.out.printf("%s %s\n", a, b);
        swap(a, b);
        System.out.printf("%s %s\n", a, b);
        
    }
    
}
