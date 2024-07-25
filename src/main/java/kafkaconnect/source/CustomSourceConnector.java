//package kafkaconnect.source;
//
//import java.util.List;
//import java.util.Map;
//
//import org.apache.kafka.common.config.ConfigDef;
//import org.apache.kafka.connect.source.SourceConnector;
//import org.apache.kafka.connect.source.SourceTask;
//
//import kafkaconnect.ConnectorConfig;
//
//public class CustomSourceConnector extends SourceConnector {
//
//	private ConnectorConfig config;
//
//	@Override
//	public void start(Map<String, String> props) {
//		config = new ConnectorConfig(null, props);
//	}
//
//	@Override
//	public Class<? extends SourceTask> taskClass() {
//		return CustomSourceTask.class;
//	}
//
//	@Override
//	public List<Map<String, String>> taskConfigs(int maxTasks) {
//		// Tek bir task configuration oluştur
//		return null;
//	}
//
//	@Override
//	public void stop() {
//		// Gerekli temizlik işlemleri
//	}
//
//	@Override
//	public ConfigDef config() {
//		return ConnectorConfig.config();
//	}
//
//	@Override
//	public String version() {
//		return "1.0";
//	}
//}
