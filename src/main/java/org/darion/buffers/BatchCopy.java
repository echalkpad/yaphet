package org.darion.buffers;

import java.nio.CharBuffer;
import java.util.Arrays;

public class BatchCopy {
	public static void main(String[] args) {
		CharBuffer buffer = CharBuffer.allocate(10);
		buffer.put("0123456789");
		buffer.flip();
		// char[] array = new char[buffer.limit()];
		char[] array = new char[8];
		// buffer.get(array);
		buffer.get(array, 0, 8);
		System.out.println(Arrays.toString(array));
	}
}
