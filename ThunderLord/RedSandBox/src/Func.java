import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Func
{

    public static void main(String[] args)
    {
        Function<Double, Double> f = (x) -> x;
        Function<Double, Double> g = (x) -> Math.pow(x, 2);

        System.out.println(directSolve(f, g, -2.0, 2.0));
        
    }
    
    public static List<Double> directSolve(Function<Double, Double> a, Function<Double, Double> b, Double start, Double end)
    {
        List<Double> result = new LinkedList<Double>();
        for (double i = start; i <= end; i+=0.1)
        {
            System.out.println(String.valueOf(i) + " " + String.valueOf(a.apply(i)) + " " + String.valueOf(b.apply(i)));
            if (a.apply(i).intValue() == b.apply(i).intValue() && result.contains(i) ) {
                result.add(i);
            }
        }
        return result;
    }
    
}
