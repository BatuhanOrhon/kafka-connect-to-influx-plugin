package kafkaconnect.sink;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;

public class CustomSinkTask extends SinkTask {

	// private InfluxDBConnection influxDBConnection;

	private FileWriter myWriter;

	@Override
	public void start(Map<String, String> props) {
		// InfluxDB'ye bağlan
		// influxDBConnection = new InfluxDBConnection(props);
		// influxDBConnection.connect();
		try {
			myWriter = new FileWriter(props.get("filename"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void put(Collection<SinkRecord> records) {
		for (SinkRecord record : records) {
			// InfluxDB'ye veriyi yaz
//			String value = record.value().toString();
//			influxDBConnection.insertStringToInfluxDB(value);
//
//			// InfluxDB'ye gönderilen veriyi logla
//			System.out.println("InfluxDB'ye yazılan veri: " + value);
			try {
				myWriter.append(record.value().toString());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public void stop() {
		// influxDBConnection.close();
		try {
			myWriter.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String version() {
		return "1.0";
	}
}
