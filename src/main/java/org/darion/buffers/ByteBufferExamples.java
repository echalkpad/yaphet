package org.darion.buffers;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

public class ByteBufferExamples {
	public static void main(String[] args) {
		// Integer valInteger = 1;
		// Float valFloat = 1.0F;
		// Double valDouble = 1.0D;
		//
		// ByteBuffer buffer = ByteBuffer.allocate(4);
		// buffer.putInt(valInteger);
		//
		// FloatBuffer floatBuffer = FloatBuffer.allocate(1);
		// floatBuffer.put(valFloat);
		//
		// DoubleBuffer doubleBuffer = DoubleBuffer.allocate(1);
		// doubleBuffer.put(valDouble);

		// ByteBuffer byteBuffer = ByteBuffer.allocate(32);
		// for (int index = 0; index < 32; index++) {
		// byteBuffer.put(new Integer(index).byteValue());
		// }
		// byteBuffer.flip();
		// for (int index = 0; index < 32; index++) {
		// byte val = byteBuffer.get();
		// System.out.println(val);
		// }

		ByteBuffer buffer = ByteBuffer.allocate(10);
		buffer.put((byte) 'H').put((byte) 'e').put((byte) 'l').put((byte) 'l')
				.put((byte) 'o');
		buffer.put(0, "M".getBytes()[0]).put((byte) 'w');

		// buffer.limit(buffer.position()).position(0);
		buffer.flip();
		int size = buffer.remaining();
		byte[] array = new byte[10];
		for (int i = 0; i < size; i++) {
			System.out.println("remaining : " + buffer.remaining());
			array[i] = buffer.get();
		}

	}
}
