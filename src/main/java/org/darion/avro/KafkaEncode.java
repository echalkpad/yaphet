package org.darion.avro;

import java.io.ByteArrayOutputStream;

import org.apache.avro.Schema;

import example.avro.User;
import kafka.serializer.Encoder;

public class KafkaEncode implements Encoder<User> {

	public byte[] toBytes(User user) {
		Schema schema = Schema
				.parse("{\"namespace\": \"example.avro\",\"type\": "
						+ "\"record\",\"name\": \"User\",\"fields\": "
						+ "[{\"name\": \"name\", \"type\": \"string\"}"
						+ ",{\"name\": \"favorite_number\",  \"type\":"
						+ " [\"int\", \"null\"]},{\"name\": \"favorite_color\","
						+ " \"type\": [\"string\", \"null\"]}]}");

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		return null;
	}

}
