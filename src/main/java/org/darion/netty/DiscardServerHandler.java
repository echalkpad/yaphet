package org.darion.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAppender;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelHandlerAppender {

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) {
    try {
      // do nothing
      ByteBuf buffer = (ByteBuf) msg;
      System.out.println(buffer.toString(CharsetUtil.US_ASCII));
    } finally {
      ReferenceCountUtil.release(msg);
    }
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {

    cause.printStackTrace();
    ctx.close();
  }
}
