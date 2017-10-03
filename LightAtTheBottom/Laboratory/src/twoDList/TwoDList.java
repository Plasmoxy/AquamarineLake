package twoDList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDList
{
	public static void main(String[] args)
	{
		
		String[][] str = {
				{"lol", "xd", "omg"},
				{"Peter", "Jozef", "Jan"}
		};
		
		List<List<String>> a = new ArrayList<List<String>>();
		
		
		for (String[] strarr : str)
		{
			a.add(new ArrayList(Arrays.asList(strarr)));
		}
		
		
		System.out.println(a.get(0).get(0));
			
		
		
	}
}
