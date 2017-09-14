package alpha;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest
{
	
	public static void main(String[] args)
	{
		
		// create trash arraylist for anything that you want
		ArrayList trash = new ArrayList(); // same as ArrayList<Object>
		
		// create lists for dogs and cats
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		ArrayList<Cat> cats = new ArrayList<Cat>();
		
		ArrayList unsorted = new ArrayList();
		
		// add some dogs and cats to trash and also some junk
		trash.addAll(Arrays.asList(
			new Dog(1), new Dog(3), "TF", new Cat(4), new Cat(5),
			new Dog(3), new Cat(6), new Dog(9), new Dog(5), "XDDD",
			false, true, "lmao", 232429, 69, 2f
		));
		
		
		System.out.println(" Trash -------------------- \n");
		for (Object i : trash) System.out.println(i.toString());
		System.out.println();
		
		// sort dogs and cats from trash to their own lists
		for (Object i : trash)
		{
				 if ( i instanceof Dog) dogs.add((Dog)i);
			else if ( i instanceof Cat) cats.add((Cat)i);
			else 						unsorted.add(i);
		}
		
		// print dogs and cats simultaneously and also unsorted stuff
		
		System.out.println(" Dogs -------------------- \n");
		for (Dog d : dogs) d.dump();
		
		System.out.println(" Cats -------------------- \n");
		for (Cat c : cats) c.dump();
		
		System.out.println(" Unsorted junk -------------------- \n");
		for (Object o : unsorted) System.out.println(o.toString());
		
	}
	
}
