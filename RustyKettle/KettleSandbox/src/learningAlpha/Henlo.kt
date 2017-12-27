package learningAlpha

class Person(var name: String)
{
    fun greet()
    {
        println("Hello im ${name}.")
    }
}

fun main(args: Array<String>)
{
    Person("John").greet()
}