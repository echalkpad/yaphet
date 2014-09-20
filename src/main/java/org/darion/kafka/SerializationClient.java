package org.darion.kafka;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.darion.protocol.Message.MessageBuffer;

import com.google.common.collect.Maps;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class SerializationClient {
	public static void main(String[] args) {
		 MessageBuffer.Builder builder = MessageBuffer.newBuilder();
		 MessageBuffer buffer = builder.setKey("key").setVal("val").build();
		
		 Properties properties = new Properties();
		 properties.put("serializer.class", "org.darion.kafka.MessageCodec");
		 properties.put("metadata.broker.list", "localhost:9092");
		 ProducerConfig config = new ProducerConfig(properties);
		 Producer<String, MessageBuffer> producer = new Producer<String,
		 MessageBuffer>(
		 config);
		 try {
		 producer.send(new KeyedMessage<String, MessageBuffer>(
		 "topic.message.buffer", buffer));
		 } finally {
		 producer.close();
		 }

//		Properties props = new Properties();
//		props.put("zookeeper.connect", "localhost:2181");
//		props.put("group.id", "darion-" + System.currentTimeMillis());
//		props.put("zookeeper.session.timeout.ms", "1000");
//		props.put("zookeeper.sync.time.ms", "500");
//		props.put("auto.commit.interval.ms", "100");
//		props.put("serializer.class", "ProtoBufMessageDecoder");
//
//		ConsumerConfig config = new ConsumerConfig(props);
//		Map<String, Integer> topicCountMap = Maps.newHashMap();
//		topicCountMap.put("", 2);
//
//		ConsumerConnector consumerConnector = Consumer
//				.createJavaConsumerConnector(config);
//
//		Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumerConnector
//				.createMessageStreams(topicCountMap);
//		// List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);
//
//		KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
//		ConsumerIterator<byte[], byte[]> iterator = stream.iterator();
//		while (iterator.hasNext()) {
//			System.out.println("Message : "
//					+ new String(iterator.next().message()));
//		}

	}
}
