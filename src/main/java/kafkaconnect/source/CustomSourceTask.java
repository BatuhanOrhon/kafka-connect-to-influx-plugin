//package kafkaconnect.source;
//
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.atomic.AtomicBoolean;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.connect.data.Schema;
//import org.apache.kafka.connect.source.SourceRecord;
//import org.apache.kafka.connect.source.SourceTask;
//
//import kafka.KafkaConnection;
//import kafkaconnect.ConnectorConfig;
//
//public class CustomSourceTask extends SourceTask {
//
//	private KafkaConnection kafkaConnection;
//	private AtomicBoolean stop;
//	private ConnectorConfig config;
//
//	@Override
//	public String version() {
//		return "1.0";
//	}
//
//	@Override
//	public List<SourceRecord> poll() throws InterruptedException {
//		if (stop.get()) {
//			return Collections.emptyList();
//		}
//		List<SourceRecord> records = new ArrayList<>();
//
//		// Kafka'dan mesajları oku
//		ConsumerRecords<String, String> messages = kafkaConnection.getConsumer()
//				.poll(Duration.ofMillis(config.getPollInterval()));
//
//		for (ConsumerRecord<String, String> message : messages) {
//
//			// Kafka'dan gelen mesajları SourceRecord listesine dönüştür
//			Map<String, String> sourcePartition = Collections.singletonMap("partition",
//					String.valueOf(message.partition()));
//			Map<String, Long> sourceOffset = Collections.singletonMap("offset", message.offset());
//			records.add(new SourceRecord(sourcePartition, sourceOffset, message.topic(), Schema.STRING_SCHEMA,
//					message.value()));
//		}
//
//		return records;
//	}
//
//	@Override
//	public void stop() {
//		stop.set(true);
//		kafkaConnection.close();
//	}
//
//	@Override
//	public void start(Map<String, String> props) {
//		stop.set(false);
//		// String bootstrapServers = props.get("bootstrap.servers");
//		// String topic = props.get("kafka.topic");
//
//		config = new ConnectorConfig(null, props);
//
//		// Kafka bağlantısını oluştur
//		kafkaConnection = new KafkaConnection(config.getBootstrapServers(), config.getTopic());
//	}
//}
