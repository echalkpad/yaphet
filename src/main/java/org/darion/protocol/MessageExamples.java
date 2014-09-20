package org.darion.protocol;

import org.darion.protocol.Message.MessageBuffer;

import com.google.protobuf.InvalidProtocolBufferException;

public class MessageExamples {
	public static void main(String[] args) {
		MessageBuffer.Builder builder = MessageBuffer.newBuilder();
		MessageBuffer messageBuffer = builder.setKey("key").setVal("val")
				.build();
		byte[] array = messageBuffer.toByteArray();
		System.out.println(array.length);

		MessageBuffer buffer = null;

		try {
			buffer = MessageBuffer.parseFrom(array);
			System.out.println(buffer.getKey());
			System.out.println(buffer.getVal());
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}

	}
}
