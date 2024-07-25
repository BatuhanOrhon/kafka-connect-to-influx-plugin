package kafkaconnect.transform;

import java.util.Map;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.transforms.Transformation;

public class CustomTransformation implements Transformation<SourceRecord> {

	@Override
	public void configure(Map<String, ?> configs) {
		// TODO Auto-generated method stub

	}

	@Override
	public SourceRecord apply(SourceRecord record) {
		String value = record.value().toString();
		value = value.toUpperCase();
		return record;
	}

	@Override
	public ConfigDef config() {
		return new ConfigDef();
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
