package com.wangzh.scala

object Test {
  def main(args: Array[String]): Unit = {
    new Outer().test
  }

  class Outer{
    class Iner{
      def start()=println("start")
      def end = println("end")
      def pause(): Unit ={
        println("pause")
      }
    }
    def test={
      new Iner().start();
      new Iner().end
      new Iner().pause();
    }
  }
}
