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

main
{
	declare int to hold number of guesses
	
	instantiate dotcom object
	make location for it ->
	compute random number between 0 and 4 ( starting location cell position)
	set the location cells to random num, rn+1, rn+2 ( therefore max 6)
	
	declare string result so while can scan it
	while dotcom is still alive  (result!="kill"):
		get user input from cmdline
		let dotcom check itself directly form user input as it has parse
		-> assign return value to result
	
	print how many guesses user had
	
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
