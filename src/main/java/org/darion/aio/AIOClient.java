package org.darion.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AIOClient {

	public static void main(String[] args) throws IOException {
		AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
		Future<?> future = channel.connect(new InetSocketAddress("127.0.0.1",
				8989));
		try {
			future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		ByteBuffer buffer = ByteBuffer.allocate(32);
		buffer.put((System.currentTimeMillis() + "").getBytes());
		buffer.flip();
		channel.write(buffer);
	}
}
