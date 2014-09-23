package org.darion.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import java.io.UnsupportedEncodingException;

public class TcpServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws UnsupportedEncodingException {
		try {
			ByteBuf in = (ByteBuf) msg;
			System.out.println("channelRead:" + in.toString(CharsetUtil.UTF_8));

			// ??????
			byte[] responseByteArray = "??".getBytes("UTF-8");
			ByteBuf out = ctx.alloc().buffer(responseByteArray.length);
			out.writeBytes(responseByteArray);
			ctx.writeAndFlush(out);

		} finally {
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		System.out.println("channelActive");
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) {
		System.out.println("channelInactive");
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}