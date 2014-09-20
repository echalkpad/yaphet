package org.darion.avro;

import example.avro.User;
import kafka.serializer.Decoder;

public class KafkaDecode implements Decoder<User> {

	@Override
	public User fromBytes(byte[] arg0) {
		return null;
	}

}
