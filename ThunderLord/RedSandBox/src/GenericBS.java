public class GenericBS
{
    static class Animal
    {
        int age;
        public Animal(int age)
        {
            this.age = age;
        }
    }
    
    static class Dog extends Animal
    {
        String name;
        public Dog(int age, String name)
        {
            super(age);
            this.name = name;
        }
    }
    
    static void whatAge(Animal a) {
        System.out.println(a.age);
    }

    public static void main(String[] args)
    {
        Dog g = new Dog(1, "XD");
        whatAge(g);
    }
}
