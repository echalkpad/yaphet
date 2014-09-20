package org.darion.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class DiscardServer implements Runnable {
  public static void main(String[] args) throws InterruptedException {
    Runnable task = new DiscardServer();
    Thread mainThread = new Thread(task);
    mainThread.run();
  }

  @Override
  public void run() {
    System.out.println("Netty Server Starting");
    int coreSize = Runtime.getRuntime().availableProcessors();
    EventLoopGroup bossGroup = new NioEventLoopGroup(coreSize);
    EventLoopGroup workGroup = new NioEventLoopGroup(coreSize * 2);
    ServerBootstrap serverBootstrap = new ServerBootstrap();

    serverBootstrap.group(bossGroup, workGroup);
    serverBootstrap.channel(NioServerSocketChannel.class);
    serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
      @Override
      protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast(new DiscardServerHandler());
      }
    });

    serverBootstrap.option(ChannelOption.SO_BACKLOG, 128);
    serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
    try {
      ChannelFuture future = serverBootstrap.bind(8989).sync();
      future.channel().closeFuture().sync();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      bossGroup.shutdownGracefully();
      workGroup.shutdownGracefully();
    }
  }
}
