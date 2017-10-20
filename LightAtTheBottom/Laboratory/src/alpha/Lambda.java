package alpha;

import java.util.Comparator;

public class Lambda
{
	
	
	public static void main(String[] args)
	{
		int a = 4;
		int b = 3;
		
		Comparator<Integer> xd = (x, y) -> {
			if (x > y) return -1;
			if (x == y) return 0;
			if (x < y) return 1;
			return -2;
		};
		
		System.out.println(xd.compare(a, b));
		
	}
}
