package simpleDotComGame;

/*
 * This class was written using Extreme Programming methodology
 * ( has test class, pseudo and all that stuff )
 * by Plasmoxy
 * 
 * 
@pseudo for SimpleDotComGame ...

int array locationCells ; to hold location cells
int numberOfHits = 0; will hold number of hits

checkYourself(String userQuess)
- takes string for user guess
- returns result of hit/miss/kill
{
	get user quess as string char
	convert guess to int
	repeat for each location cell in int array
		compare user quess to location cell
		if user quess matches
			hits++
			find out if it was the last location cell
			-> if number of hits is 3, return kill as result
			else it wasnt a kill so return hit
		else
			user didnt hit so return miss
	
}

setLocationCells(int[] cellLocations)
- setter that takes int array with three cell locations
{
	get the cell locations as int array
	assign cell locations parameter to cell locations instance variable
}

*/

public class SimpleDotCom
{
	
	private int[] locationCells;
	private int numOfHits;
	
	public void setLocationCells(int[] locs)
	{
		locationCells = locs;
	}
	
	public String checkYourself(String stringGuess)
	{
		int guess = Integer.parseInt(stringGuess);
		String result = "miss"; // default
		
		for (int cell : locationCells) // hit scanner
		{
			if ( guess == cell)
			{
				result = "hit";
				numOfHits++;
				break; // get out of the loop, no need to test other cells
			}
		}
		
		if ( numOfHits == locationCells.length)
		{
			result = "kill";
		}
		
		System.out.println(result); // display to user
		
		return result;
		
	}
	
}
