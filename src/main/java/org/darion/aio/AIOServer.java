package org.darion.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

public class AIOServer {
	public static void main(String[] args) throws IOException {
		System.out.println("Server StartUp ... ");
		final AsynchronousServerSocketChannel channel = AsynchronousServerSocketChannel
				.open().bind(new InetSocketAddress(8989));

		channel.accept(null,
				new CompletionHandler<AsynchronousSocketChannel, Void>() {

					@Override
					public void completed(AsynchronousSocketChannel result,
							Void attachment) {
						channel.accept(null, this);
						handler(result);
					}

					@Override
					public void failed(Throwable exc, Void attachment) {

					}
				});
		
		try {
			Thread.sleep(1000*3600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void handler(AsynchronousSocketChannel channel) {
		ByteBuffer buffer = ByteBuffer.allocate(32);
		try {
			channel.read(buffer).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		buffer.flip();
		System.out.println(buffer.get());
	}
}
