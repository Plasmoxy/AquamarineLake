public class Faktorial
{
	
	public static int f(int n)
	{
		int a = n;
		n--;
		for (;n>0; n--)
		{
			a*=n;
		}
		
		return a;
	}

	public static void main(String[] args)
	{
		final int t = 5;
		System.out.println(f(t)); 
	}
}
