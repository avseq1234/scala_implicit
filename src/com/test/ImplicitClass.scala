package com.test

/**
  * Created by Honda on 2017/11/6.
  */
object ImplicitClassDemo {


  //
  // The implicit class will be convert to implicit function string2Dog(name:String) = new Dog(name)
  // This is identical to implicit function
  // Only one parameter can be in the implicit class constructor.
  //
  implicit class Dog( val name:String )
  {
    def bark = println(s"$name is barking")
  }

  def main(args: Array[String]): Unit = {
    "haha".bark
  }
}
