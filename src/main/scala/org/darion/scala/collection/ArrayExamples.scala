package org.darion.scala.collection

object ArrayExamples {
  def main(args: Array[String]) {
    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    //    array map { print(_) }
    array.filter((_ % 2 == 0)).map(println(_))

  }
}