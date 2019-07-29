package com.wangzh.scala

import java.util.UUID

import scala.collection.mutable.ArrayBuffer

/**
  * 总结：
  * 1）object里面的方法都是静态方法
  * 2）object里面的字段都是静态字段
  * 3）它本身就是一个单例，(因为不需要去new)
  */
object TestObject {
  def main(args: Array[String]): Unit = {
    val session = SessionUtils.getSession() //类似JAVA中调用工具类的static method
    println(SessionUtils.sessions.size)  //类似JAVA中调用工具类的static field
    session.printName()
  }
}

//伴生类
//伴生对象和伴生类可以互相访问私有属性和私有方法。
class Session(name:String){
  def printName() = {
    val sid = Session.generateId
    println(s"session[$sid] name=$name")
  }
}

//伴生对象
object Session{
  //apply方法实际上是一个快捷方式，可以使用小括号触发功能而不需要方法名
  //Session.apply("test") 等同于 Session("test")，List获取元素的List(1)也是apply方法再起作用
  def apply(name: String): Session = new Session(name)

  //私有字段或方法
  private def generateId = UUID.randomUUID()
}

/**
  * 在Scala中没有静态方法和静态字段，但是可以使用object这个语法结构来达到同样的目的
  * 1.存放工具方法和常量
  * 2.高效共享单个不可变的实例=单例模式
  */
object SessionUtils{
  //该部分相当于java中的静态块
  var counts = 5
  val sessions = new ArrayBuffer[Session]()
  while (counts > 0){
    sessions += Session("SN"+counts)  //apply()工厂模式：从Session伴生对象生产一个Session类实例
    counts -= 1
  }
  //在object中的方法相当于java中的静态方法
  def getSession(): Session ={
    sessions.remove(0)
  }

}
