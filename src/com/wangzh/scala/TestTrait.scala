package com.wangzh.scala

object TestTrait {
  def main (args: Array[String] ): Unit = {
    val w1 = new Worker("w1")
    w1.printMsg("你好")
    val w2 = new Worker("w2")
    w2.printLog("run successed")

  }
}

trait MsgTrait{
  //具体field，被继承后,字段成为子类的字段（区别于class的继承类中继承的字段是父类的）
  val msgHeader:String = "from MsgTrait,"
  //抽象method
  def printMsg(msg: String)
}

trait LogTrait{
  //抽象field，可以在trait的具体方法中使用，但是继承类需要覆盖并赋值
  val logLevel:String
  //具体method
  def printLog(log:String): Unit = println("from LogTrait, logLevel="+logLevel+",log="+log)
}

class Worker(val name:String) extends LogTrait with MsgTrait{
  //实现LogTrait中的抽象字段
  val logLevel:String = "INFO"
  //实现MsgTrait中的抽象方法，不需要override
  def printMsg(msg: String): Unit = println("from Worker "+name+",msgHeader="+msgHeader+",msg="+msg)
  //重载trait中的实现方法，要加override
  override def printLog(log:String): Unit =  {
    println("from Worker "+name)
    super.printLog(log)
  }

}


