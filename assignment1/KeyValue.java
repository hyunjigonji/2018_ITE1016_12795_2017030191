package assignment1;

import java.util.StringTokenizer;

public class KeyValue {
	public KeyValue(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public KeyValue(String line){ // 1 line Constructor
		StringTokenizer token = new StringTokenizer(line, "=");
		this.key = token.nextToken();
		this.value = token.nextToken();
	}
	public String getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	private String key;
	private String value;
}

