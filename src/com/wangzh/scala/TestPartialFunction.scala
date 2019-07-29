package com.wangzh.scala

/**
  * 总结：偏函数就是用来做模式匹配的。
  */
object TestPartialFunction {
  def main(args: Array[String]): Unit = {
    println(f1("one"))
    println(f2("one"))
  }

  //偏函数
  //被包在花括号内没有match的一组case语句是一个偏函数，它是PartialFunction[A, B]的一个实例，A代表参数类型，B代表返回类型，常用作输入模式匹配
  def f1:PartialFunction[String,Int] = {
    case "one" => 1
    case "two" => 2
    case _ => -1
  }

  //普通函数，用match做模式匹配
  def f2(num:String):Int = num match {
    case "one" => 1
    case "two" => 2
    case _ => -1
  }
}


