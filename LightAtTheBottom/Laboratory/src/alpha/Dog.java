package alpha;

public class Dog
{
	private int age;
	
	public Dog(int age)
	{
		this.age = age;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void bark()
	{
		System.out.println("Bark bark");
	}
	
	public void dump()
	{
		System.out.println(this.toString() + " with age " + Integer.toString(age));
		bark();
		System.out.println();
	}
	
}
