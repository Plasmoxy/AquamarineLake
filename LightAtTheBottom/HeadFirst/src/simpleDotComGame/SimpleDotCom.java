package simpleDotComGame;

import java.util.Arrays;

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
	compute random number between 0 and 4 ( starting location cell position)
	make location for it -> create array n,n+1,n+2
	set the location cells of instance to the array
	
	declare boolean isAlive so while can scan it
	while dotcom is still alive :
		get user input from cmdline
		let dotcom check itself directly form user input as it has parse
		-> pass it to if
		// it will automatically printout what happened and assign it to its inst
		// variables so therefore we'll just check for the kill
		if result is "kill" :
			set isAlive to false so we break out of the loop
			print the number of guesses
	
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
		
		for (int i = 0; i < locationCells.length; i++) // hit scanner
		{
			if ( guess == locationCells[i])
			{
				result = "hit";
				numOfHits++;
				locationCells[i] = -1;
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
	
	public static void main(String[] args)
	{
		int numOfGuesses = 0;
		
		GameHelper helper = new GameHelper(); // wtf class with user input capabilities
		SimpleDotCom theDotCom = new SimpleDotCom(); // create dot com ship
		
		int randomNum = (int) ( Math.random() * 5);
		int[] locations = {randomNum, randomNum+1, randomNum+2};
		
		theDotCom.setLocationCells(locations);
		boolean isAlive = true;
		
		while (isAlive)
		{
			System.out.println(Arrays.toString(locations));
			String guess = helper.getUserInput("Enter a number");
			String result = theDotCom.checkYourself(guess);
			numOfGuesses++;
			if (result.equals("kill"))
			{
				isAlive = false;
				System.out.println("You took " + numOfGuesses + " guesses.");
			}
		}
		
		
	}
	
}
