package simpleDotComGame;

public class SimpleDotComTESTER
{
	public static void main(String[] args)
	{
		SimpleDotCom dot = new SimpleDotCom(); // instantiate dotcom
		
		int[] locations = {2,3,4}; // testing arrayinput
		
		dot.setLocationCells(locations);
		
		String hitguess = "2"; // fake user quess, 2 should be hit
		
		String result = dot.checkYourself(hitguess);
		
		System.out.println(
				result.equals("hit") ? "passed" : "failed"
				// test if its hit
		);
		
		
	}
}
