package com.test

/**
  * Created by Honda on 2017/11/6.
  */
object ImplicitObjectDemo {

  trait Multiplicable[T]
  {
    def multiply(x:T):T
  }

  implicit object MultiplicableInt extends Multiplicable[Int]
  {
    override def multiply(x: Int): Int = x*x
  }

  implicit object MultiplicableString extends Multiplicable[String]
  {
    override def multiply(x: String): String = x*2
  }


  //
  // [T:Multiplicable] means there must be a implicit Multicable[T] object or value in the scope.
  //

  def multiply[T:Multiplicable](x:T) =
  {

    // implicitly is defined in Predef
    // inline def implicitly[T](implicit e:T) = e
    // So when we invoke multiply multiply(5) , the type of T is defined as Int
    // So it will search are there any object is Multiplicable[Int] , for example MultiplicableInt ,  pass it into implicitly
    val ev = implicitly[Multiplicable[T]]
    ev.multiply(x)
  }

  //
  // multiply1 is identical with multiply
  //

  def multiply1[T:Multiplicable](x:T)( implicit m: Multiplicable[T])=
  {
    m.multiply(x)
  }

  def main(args: Array[String]): Unit = {
    println( multiply(5))
    println(multiply("5"))
  }
}
