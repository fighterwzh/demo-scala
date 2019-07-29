package com.wangzh.scala

/**
  * 总结：
  *
  * 主构造方法：
  * 1）与类名交织在一起
  * 2）主构造方法运行，导致类名后面的大括号里面的代码都会运行
  * 辅助构造方法：
  * 1）必须名字叫thi
  * 2) 必须以调用主构造方法或者是其他辅助构造方法开始。
  * 3）里面的属性不能写修饰符
  */
object TestClass {
  def main(args: Array[String]): Unit = {
    val p:Person = new Person("wangzh",20,"三里屯")
  }
}

/**
  * 每个类都有主构造器，主构造器的参数直接放置类名后面，与类交织在一起
  * 注意：主构造器会执行类定义中的所有语句
  */
class Person(name:String,age:Int){
  //主构造器会执行类定义中的所有语句
  println("Hello Spark")

  val x = 1
  if(x > 1){
    println("666")
  }else if(x < 1){
    println("哈哈。。。")
  }else{
    println("呵呵。。。")
  }

  private var address = "BJ"
  //用this关键字定义辅助构造器
  def this(name:String,age:Int,address:String){
    //每个辅助构造器必须以主构造器或其他的辅助构造器的调用开始
    this(name,age)
    println("执行辅助构造器")
    this.address = address
  }

}
