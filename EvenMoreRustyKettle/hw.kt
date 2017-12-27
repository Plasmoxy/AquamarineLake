@file:JvmName("hw")

class Printer
{
  var print = {
    println("hello")
  }
}

fun main(args: Array<String>)
{
  var a = Add() // use java class
  println(a.add(4,4))
  var p = Printer()
  p.print()
}
