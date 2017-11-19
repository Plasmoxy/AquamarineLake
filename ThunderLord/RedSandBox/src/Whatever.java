import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Whatever
{
    static class Animal
    {
        public int age;
        public Animal(int a)
        {
            age = a;
        }
    }
    
    static class Dog extends Animal
    {
        public String name;
        public Dog(int a, String n)
        {
            super(a);
            name = n;
        }
    }
    
    public <T extends Animal> T older(T a, T b)
    {
        return a.age > b.age ? a : b;
    }
    
    public static void main(String[] args) throws IOException
    {
        Whatever w = new Whatever();
        Animal a = new Animal(5);
        Dog d = new Dog(25, "Jake");

        System.out.println(w.older(a, d).age);
        
    }
    
}
