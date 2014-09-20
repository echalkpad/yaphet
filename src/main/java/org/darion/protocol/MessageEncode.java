package org.darion.protocol;

import org.darion.protocol.Message.MessageBuffer;

import kafka.serializer.Encoder;

public class MessageEncode implements Encoder<MessageBuffer> {

	@Override
	public byte[] toBytes(MessageBuffer message) {
		byte[] array = message.toByteArray();
		return array;
	}
}
