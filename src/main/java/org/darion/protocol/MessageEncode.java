package org.darion.protocol;

import org.darion.protocol.Message.MessageBuffer;

import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

public class MessageEncode implements Encoder<MessageBuffer> {

	public MessageEncode(VerifiableProperties properties) {

	}

	@Override
	public byte[] toBytes(MessageBuffer message) {
		byte[] array = message.toByteArray();
		return array;
	}
}
