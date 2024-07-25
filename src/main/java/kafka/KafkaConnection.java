//package kafka;
//
//import java.util.Properties;
//
//import org.apache.kafka.clients.consumer.Consumer;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.common.serialization.StringDeserializer;
//
//public class KafkaConnection {
//
//	private final Consumer<String, String> consumer;
//
//	public KafkaConnection(String bootstrapServers, String groupId) {
//		Properties props = new Properties();
//		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
//		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//
//		this.consumer = new KafkaConsumer<>(props);
//	}
//
//	public Consumer<String, String> getConsumer() {
//		return consumer;
//	}
//
//	public void close() {
//		consumer.close();
//	}
//}