package alpha;

public class Cat
{
	private int age;
	
	public Cat(int age)
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
	
	public void meow()
	{
		System.out.println("Meow meow");
	}
	
	public void dump()
	{
		System.out.println(this.toString() + " with age " + Integer.toString(age));
		meow();
		System.out.println();
	}
	
}
