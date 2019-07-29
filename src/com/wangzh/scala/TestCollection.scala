package com.wangzh.scala

object TestCollection {
  def main(args: Array[String]): Unit = {
    val colors = List("red","green","","blue")
    colors.filter(!_.isEmpty).foreach(x=>println(x))

    colors.sortBy(_.size).foreach(println(_))

    colors.map(_.size).foreach(println(_))

    val sum = colors.map(_.size).reduce((x,y)=>x+y)
    val sum2 = colors.map(_.size).reduce(_+_)
    println(s"sum=$sum,sum2=$sum2")
  }

}
