package com.wangzh.scala


object TestMatch {
  def main(args: Array[String]): Unit = {

    println(stringMatch("one"))
    println(listMatch(List(1,2)))
    println(caseClassMatch(Product("apple","红富士",3.5f)))
  }

  def stringMatch(num:String):Int = {
    num match {
      case "one" => 1
      case "two" => 2
      case _ => - 1
    }
  }

  def listMatch(arr:scala.collection.immutable.List[Int]): String = {
    arr match {
      case 1::Nil => "List(1)"
      case 1::2:: Nil => "List(1,2)"
      case _ => "Unknown"
    }
  }

  def caseClassMatch(p:Product):String = {
    p match {
      case Product("apple",x,y) => s"苹果,category=$x,price=$y"
      case Product("banana",x,y) => s"香蕉,category=$x,price=$y"
      case _ => "Unknown"
    }
  }


}

/*case class Product(name:String,category:String,price:Float){
  def printInfo = println(s"name=$name,category=$category,price=$price")
}*/


