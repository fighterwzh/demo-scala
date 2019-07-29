package com.wangzh.scala

object TestFunction {
  def main(args: Array[String]): Unit = {
    //高级函数中函数作为参数传入
    //方式1
    val r1 = safeStringOp("abc",reverser)
    println("方式1，ret="+r1)

    //方式2：使用函数字面量（也叫：匿名函数、Lambda表达式）
    val r2 = safeStringOp("def", s=>s.reverse)
    println("方式2，ret="+r2)

    //方式3：使用函数字面量占位符
    val r3 = safeStringOp("xyz", _.reverse)
    println("方式3，ret="+r3)
  }

  //定义高级函数
  def safeStringOp(s:String,f:String=>String) = {
    if(s!=null) f(s) else s
  }

  //定义普通函数
  def reverser(s:String) = s.reverse
}
