package org.darion.commons;

import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.io.IOException;

public class Nio2ReadLargeLogFile implements
		CompletionHandler<Integer, AsynchronousFileChannel> {

	// need to keep track of the next position.
	int pos = 0;
	AsynchronousFileChannel channel = null;
	ByteBuffer buffer = null;

	public void completed(Integer result, AsynchronousFileChannel attachment) {
		// System.out.println("bytes num " + result);
		// if result is -1 means nothing was read.
		if (result != -1) {
			pos += result; // don't read the same text again.
							// your output command.
			// 这里必须读取0,result直接的buffer，否则会读取到垃圾数据
			System.out.print(new String(buffer.array(), 0, result));

			// buffer.clear(); // reset the buffer so you can read more.
			buffer.flip();
			attachment.read(buffer, pos, attachment, this);
		} else {
			return;
		}
		// initiate another asynchronous read, with this.

	}

	public void failed(Throwable exc, AsynchronousFileChannel attachment) {
		System.err.println("Error!");
		exc.printStackTrace();
	}

	public void doit() {
		Path file = Paths.get("/tmp/test");
		AsynchronousFileChannel channel = null;
		try {
			channel = AsynchronousFileChannel.open(file);
		} catch (IOException e) {
			System.err.println("Could not open file: " + file.toString());
			System.exit(1); // yeah. heh.
		}
		buffer = ByteBuffer.allocate(1000);

		// start off the asynch read.
		channel.read(buffer, pos, channel, this);
		// this method now exits, thread returns to main and waits for user
		// input.
	}

	public static void main(String[] args) {
		Nio2ReadLargeLogFile tn = new Nio2ReadLargeLogFile();
		tn.doit();
		// wait fur user to press a key otherwise java exits because the
		// asynch thread isn't important enough to keep it running.
		try {
			System.in.read();
		} catch (IOException e) {
		}
	}
}
