package org.darion.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelExamples {
	private static final int DEFAULT_BUFFER_SIZE = 1024 * 8;

	public static void main(String[] args) throws IOException {
		ReadableByteChannel source = Channels.newChannel(System.in);
		WritableByteChannel target = Channels.newChannel(System.out);
		channelCopy(source, target);
		source.close();
		target.close();
	}

	private static void channelCopy(ReadableByteChannel source,
			WritableByteChannel target) throws IOException {

		ByteBuffer buffer = ByteBuffer.allocate(DEFAULT_BUFFER_SIZE);
		while (source.read(buffer) != -1) {
			buffer.flip();
			target.write(buffer);
			buffer.compact();
		}
		buffer.compact();
		while (buffer.hasRemaining()) {
			target.write(buffer);
		}
	}
}
