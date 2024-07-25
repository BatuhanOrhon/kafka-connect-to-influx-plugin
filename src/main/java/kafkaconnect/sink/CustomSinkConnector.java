package kafkaconnect.sink;

import java.util.List;
import java.util.Map;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;

import kafkaconnect.ConnectorConfig;

public class CustomSinkConnector extends SinkConnector {

	private Map<String, String> configProperties;

	@Override
	public void start(Map<String, String> props) {
		configProperties = props;
	}

	@Override
	public Class<? extends Task> taskClass() {
		return CustomSinkTask.class;
	}

	@Override
	public List<Map<String, String>> taskConfigs(int maxTasks) {
		// Tek bir task configuration oluştur
		return List.of(configProperties);
	}

	@Override
	public void stop() {
		// Gerekli temizlik işlemleri
	}

	@Override
	public ConfigDef config() {
		return ConnectorConfig.config();
	}

	@Override
	public String version() {
		return "1.0";
	}
}