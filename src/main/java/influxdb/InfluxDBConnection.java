//package influxdb;
//
//import java.util.Map;
//
//import org.influxdb.InfluxDB;
//import org.influxdb.InfluxDBFactory;
//
//import com.influxdb.client.InfluxDBClient;
//import com.influxdb.client.InfluxDBClientFactory;
//
//import kafkaconnect.ConnectorConfig;
//
//public class InfluxDBConnection {
//	private String influxDBUrl;
//	private String username;
//	private String password;
//	private String token;
//	private InfluxDBClient client;
//
//	private ConnectorConfig config;
//
//	public InfluxDBConnection(Map<String, String> props) {
//		config = new ConnectorConfig(null, props);
//		this.influxDBUrl = config.getInfluxDBUrl();
//		this.username = config.getInfluxUsername();
//		this.password = config.getInfluxPassword();
//		this.token = config.getInfluxToken();
//	}
//
//	public void connect() {
//		if (this.client == null)
//			client = InfluxDBClientFactory.create(influxDBUrl, token.toCharArray());
//	}
//
//	public void close() {
//		if (this.client != null) {
//			this.client.close();
//			this.client = null;
//		}
//	}
//
//	/*
//	 * public void insertStringToInfluxDB(String data) { Point point =
//	 * Point.measurement("mem").addTag("host", "host").addField("custom_field",
//	 * data).time(Instant.now(), WritePrecision.NS);
//	 * 
//	 * String retentionPolicy = "defaultRetentionPolicy";
//	 * 
//	 * WriteApiBlocking writeApi = client.getWriteApiBlocking(); // TODO
//	 * client.makeWriteApi(); Buna da bakalım writeApi.writePoint("MyCustomBucket",
//	 * "MyCustomOrg", point); }
//	 */
//
//	public void insertStringToInfluxDB(String data) {
//		org.influxdb.dto.Point point = org.influxdb.dto.Point.measurement("MyMeasurement").addField("data", data)
//				.build();
//		point.lineProtocol();
//		InfluxDB influxDB = InfluxDBFactory.connect(influxDBUrl, username, password);
//		influxDB.setDatabase("MyCustomDb");
//		influxDB.write(point);
//
//		// BatchPoints batchPoints =
//		// BatchPoints.database("MyCustomDb").points(List.of(point)).build();
//		// influxDB.write(batchPoints);
//
//	}
//
//	/*
//	 * public void writeToInfluxDB(String data) { MediaType mediaType =
//	 * MediaType.parse("application/json"); String requestBody =
//	 * "measurement,tag1=value1,tag2=value2 field1=value3,field2=value4";
//	 * 
//	 * OkHttpClient client = new OkHttpClient(); Request request = new
//	 * Request.Builder().url(influxDBUrl + "/write?db=mydb")
//	 * .post(RequestBody.create(mediaType, requestBody)) .addHeader("Authorization",
//	 * Credentials.basic(username, password)).build();
//	 * 
//	 * try { Response response = client.newCall(request).execute(); if
//	 * (!response.isSuccessful()) { throw new
//	 * IOException("Unexpected response code: " + response); } } catch (IOException
//	 * e) { e.printStackTrace(); // TODO Handle exception } }
//	 */
//}