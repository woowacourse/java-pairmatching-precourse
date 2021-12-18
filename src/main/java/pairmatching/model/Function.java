package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.model.Error.WRONG_FUNCTION_INPUT_ERROR;

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

	public static Function getFunctionByKey(String key) {
		return Arrays.stream(Function.values())
				.filter(function -> function.key.equals(key))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException(WRONG_FUNCTION_INPUT_ERROR));
	}

	public static List<String> getFunctionKeys() {
		return Arrays.stream(Function.values())
				.map(function -> function.key)
				.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return key + ". " + name;
	}
}
