package org.darion.scala.io

import scala.io.Source

object ReaderAndWriter {
  def main(args: Array[String]) {
    val path = "/tmp/file.io"

    val readSource = Source.fromFile(path, "utf8")
    readSource.getLines.foreach(line => println(line))
    readSource.close

  }
}