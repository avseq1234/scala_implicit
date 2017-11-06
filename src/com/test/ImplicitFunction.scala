package com.test

/**
  * Created by Honda on 2017/11/6.
  */
object ImplicitFunction {

  // Because we have implicit function , so float can be converted to int implicitly
  implicit def float2int(x:Float) = x.toInt
  val intValue:Int = 2.55f

  // We can use ImplicitFunction to convert an object to another object
  // For example , String didn't has insert function, but StringBuilder has it
  // So we can use implicit function to conver String to StringBuilder
  val a = "abc"
  implicit def str2StrBuf(x:String) = new StringBuilder(x)
  a.insert(3,"ee")
}
