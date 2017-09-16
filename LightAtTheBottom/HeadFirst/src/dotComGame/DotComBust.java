package dotComGame;


// i have no idea how it works xdd

import java.util.ArrayList;

public class DotComBust
{
	
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	private void setUpGame()
	{
		// make some dotcoms and give them locations
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("Go2.com");
		
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		System.out.println("Your goal is to sink three dot com ships ( yes, wtf xd )");
		System.out.println("Pets.com, eToys.com, Go2.coms");
		System.out.println("Try to sink them all in the fewest number of guesses");
		
		for (DotCom dotComToSet : dotComsList)
		{
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
		
		
	}
	
	private void startPlaying()
	{
		while (!dotComsList.isEmpty())
		{
			String userGuess = helper.getUserInput("Enter guess: ");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	private void checkUserGuess(String userGuess)
	{
		numOfGuesses++;
		String result = "miss";
		
		for (DotCom dotComToTest : dotComsList)
		{
			result = dotComToTest.checkYourself(userGuess);
			if (result.equals("hit")) break;
			if (result.equals("kill"))
			{
				dotComsList.remove(dotComToTest);
				break;
			}
		}
		System.out.println(result);
	}
	
	private void finishGame()
	{
		System.out.println("All dot coms are ded xD.");
		System.out.println("It took you " + numOfGuesses + " guesses.");
		if (numOfGuesses <= 18)
			System.out.println("GGWP");
		else
			System.out.println("You played like schitt.");
	}
	
	public static void main(String[] args)
	{
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
	
}

