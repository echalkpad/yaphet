package org.darion.protocol;

import org.darion.protocol.Message.MessageBuffer;

import com.google.protobuf.InvalidProtocolBufferException;

import kafka.serializer.Decoder;

public class MessageDecode implements Decoder<MessageBuffer> {

	@Override
	public MessageBuffer fromBytes(byte[] bytes) {
		MessageBuffer message = null;
		
		try {
			message = MessageBuffer.parseFrom(bytes);
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}
		return message;
	}

}
