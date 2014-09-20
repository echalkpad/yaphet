package org.darion.buffers;

import java.nio.CharBuffer;

public class Examples {
	public static void main(String[] args) {
		String val = "Hello Buffer";
		// CharBuffer buffer = CharBuffer.wrap(val, 0, val.length());
		CharBuffer buffer = CharBuffer.allocate(9);
		buffer.put(val.toCharArray(), 6, 6);

		CharBuffer duplicateBuffer = buffer.duplicate();
		System.out.println(duplicateBuffer.array());
		buffer.position(0).limit(6);
		CharBuffer slienceBuffer = buffer.slice();
		System.out.println(slienceBuffer.array());
	}
}
