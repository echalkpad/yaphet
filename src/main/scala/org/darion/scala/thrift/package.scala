package org.darion.scala

import org.apache.thrift.transport.TServerSocket
import org.apache.thrift.server.TSimpleServer
import org.apache.thrift.server.TServer.Args

package object thrift {
  def main(args: Array[String]) {
    val serverTransport = new TServerSocket(8989);
    val args = new Args(serverTransport)
    args.processor(processor)
    val server = new TSimpleServer(args)
    
  }
}