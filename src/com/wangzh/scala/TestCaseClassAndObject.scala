package com.wangzh.scala

object TestCaseClassAndObject {
  def main(args: Array[String]): Unit = {
    val p1 = Product("apple","hfs",3.5f)
    p1.printInfo
    val p2 = p1.copy(category = "LZS",price = 4.0f)
    p2.printInfo
    println(p1==p2)
  }
}

/**
  * 本质上来讲，class  case class用起来就是一样的：
  * 最不一样的一个东西：如果我们scala要做模式匹配，去匹配类型的话，建议使用case class
  * 因为scala的底层对它做了优化，匹配起来性能较好。
  * * 1:case class 自动生成伴生对象，自动实现了apply方法
  * * 2:case class 用于做匹配，性能较好（scala的底层做过优化）
  * * 3：case class 默认实现了序列化 Serializable
  * * 4: case class 默认实现了toString equals copy等方法
  * * 5：case class 主构造函数 里面没有修饰符，默认的是val
  *
  * @param name
  * @param category
  * @param price
  */
case class Product(name:String,category:String,price:Float){
  def printInfo = println(s"name=$name,category=$category,price=$price")
}

