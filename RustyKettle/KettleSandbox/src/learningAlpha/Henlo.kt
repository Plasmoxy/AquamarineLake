package learningAlpha

class Person(var name: String)
{
    fun chainGreet() : Person { // fluent interface
        greet()
        return this
    }

    fun greet() {
        println("Hello im ${name}.")
    }
}

fun main(args: Array<String>)
{
    var a = Person("John").chainGreet()
    var b = Person("Mark").chainGreet()
}