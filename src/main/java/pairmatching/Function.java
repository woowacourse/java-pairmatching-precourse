package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Function {
	MATCHING("1", "페어 매칭"),
	SELECT("2", "페어 조회"),
	RESET("3", "페어 초기화"),
	QUIT("Q", "종료");

	private final String key;
	private final String name;

	Function(String key, String name) {
		this.key = key;
		this.name = name;
	}

	public static List<Function> getFunctionList() {
		return new ArrayList<>(Arrays.asList(values()));
	}

	public static boolean isContainsKey(String key) {
		return Arrays.stream(values())
			.map(f -> f.key)
			.anyMatch(k -> k.equals(key));
	}

	public static Function byKey(String key) {
		return Arrays.stream(values())
			.filter(f -> f.key.equals(key))
			.findFirst()
			.orElse(null);
	}

	@Override
	public String toString() {
		return key + ". " + name;
	}
}
