package org.darion.avro;

import example.avro.User;
import kafka.serializer.Decoder;
import kafka.utils.VerifiableProperties;

public class KafkaDecode implements Decoder<User> {

	public KafkaDecode(VerifiableProperties properties) {
	}

	public User fromBytes(byte[] arg0) {
		return null;
	}

}
