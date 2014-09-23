package org.darion.scala.collection

object ParallelCollectionExamples {
  def main(args: Array[String]) {
    val list = (1 to 8).toList
    list.map(_ + 1)
  }
}