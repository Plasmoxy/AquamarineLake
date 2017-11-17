package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SumSorting
{
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(-4);
        
        Collections.sort(list);

        System.out.println(list);
    }
}
