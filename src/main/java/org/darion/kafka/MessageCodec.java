package org.darion.kafka;

import org.darion.protocol.Message.MessageBuffer;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.protobuf.InvalidProtocolBufferException;

import kafka.serializer.Decoder;
import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

public class MessageCodec implements Encoder<MessageBuffer>,
		Decoder<MessageBuffer> {

	public MessageCodec(VerifiableProperties properties) {
	}

	public MessageBuffer fromBytes(byte[] array) {
		checkNotNull(array);
		MessageBuffer buffer = null;
		if (array.length == 0) {
			return buffer;
		}

		try {
			buffer = MessageBuffer.parseFrom(array);
		} catch (InvalidProtocolBufferException e) {
			System.err.println("InvalidProtocolBuffer : " + e.getMessage());
		}
		return buffer;
	}

	public byte[] toBytes(MessageBuffer buffer) {
		checkNotNull(buffer);
		byte[] array = buffer.toByteArray();
		return array;
	}
}
