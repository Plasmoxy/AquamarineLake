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
		System.out.println(f(5));
	}
}
