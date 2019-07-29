package com.wangzh.scala

/**
  * Scala中使用关键字lazy来定义惰性变量，实现延迟加载(懒加载)。
  * 惰性变量只能是不可变变量，并且只有在调用惰性变量时，才会去实例化这个变量。
  */
object TestLazyVal {
  def initName():String={
    println("wangzh 666")
    return "wangzh"
  }

  def main(args: Array[String]): Unit = {
    //在声明name时，并没有立即调用实例化方法initName(),而是在使用name时，才会调用实例化方法,并且无论缩少次调用，实例化方法只会执行一次。
    lazy val name = initName();
    println("666")
    println(name);
    println(name);
  }
}
