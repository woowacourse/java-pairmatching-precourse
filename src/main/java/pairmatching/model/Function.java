package pairmatching.model;

import java.util.Arrays;
import java.util.List;

public enum Function {
	MATCH("1", "페어 매칭"),
	SEARCH("2", "페어 조회"),
	RESET("3", "페어 초기화"),
	QUIT("Q", "종료");

	private String key;
	private String name;

	Function(String key, String name) {
		this.key = key;
		this.name = name;
	}

	public static List<Function> getFunctions() {
		return Arrays.asList(values());
	}

	@Override
	public String toString() {
		return key + ". " + name;
	}
}
