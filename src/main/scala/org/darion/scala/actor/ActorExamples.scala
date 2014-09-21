package org.darion.scala.actor

import actors._, Actor._

object ActorExamples {
  def main(args: Array[String]): Unit = {
    val caller = self
    val accumulator = actor {
      var continue = true
      var sum = 0
      loopWhile(continue) {
        reactWithin(500) {
          case number: Int => sum += number
          case TIMEOUT =>
            continue = true
            caller ! sum
        }
      }
    }

    for (index <- 1 to 100) {
      accumulator ! index
    }

    receiveWithin(1000) {
      case result => println("Total is " + result)
    }
  }
}