package kafkaconnect;

import java.util.Map;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import lombok.Getter;

@Getter
public class ConnectorConfig extends AbstractConfig {
//	public static final String INFLUX_DB_URL = "influxdb.url";
//	public static final String BOOTSTRAP_SERVERS = "bootstrap.servers";
//	public static final String GROUP_ID = "group.id";
//	public static final String TOPIC = "topic";
//	public static final String POLL_INTERVAL = "poll.interval";
//	public static final String INFLUX_USERNAME = "influxdb.username";
//	public static final String INFLUX_PASSWORD = "influxdb.password";
//	public static final String INFLUX_TOKEN = "influxdb.token";
//
//	private String influxDBUrl;
//	private String bootstrapServers;
//	private String groupId;
//	private String topic;
//	private Long pollInterval;
//	private String influxUsername;
//	private String influxPassword;
//	private String influxToken;

	public static final String FILE_NAME = "filename";

	private String filename;

	public ConnectorConfig(ConfigDef definition, Map<?, ?> originals) {
		super(config(), originals);

		this.filename = this.getString(FILE_NAME);
//		this.influxDBUrl = this.getString(INFLUX_DB_URL);
//		this.bootstrapServers = this.getString(BOOTSTRAP_SERVERS);
//		this.groupId = this.getString(GROUP_ID);
//		this.topic = this.getString(TOPIC);
//		this.pollInterval = this.getLong(POLL_INTERVAL);
//		this.influxUsername = this.getString(INFLUX_USERNAME);
//		this.influxPassword = this.getString(INFLUX_PASSWORD);
//		this.influxToken = this.getString(INFLUX_TOKEN);
	}

	public static ConfigDef config() {
		return new ConfigDef().define(FILE_NAME, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "Filename");
//				.define(INFLUX_DB_URL, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "InfluxDB URL")
//				.define(BOOTSTRAP_SERVERS, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "Bootstrap servers")
//				.define(GROUP_ID, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "Group ID")
//				.define(TOPIC, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "Topic")
//				.define(POLL_INTERVAL, ConfigDef.Type.LONG, ConfigDef.Importance.HIGH, "Poll interval")
//				.define(INFLUX_USERNAME, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "InfluxDB username")
//				.define(INFLUX_PASSWORD, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "InfluxDB password")
//				.define(INFLUX_TOKEN, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "InfluxDB token");
		// TODO Password diye bir type da var.

	}

}
