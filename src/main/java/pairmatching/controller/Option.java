package pairmatching.controller;

import java.util.Arrays;

public enum Option {
	MATCH("1"),
	PRINT("2"),
	INIT("3"),
	QUIT("Q"),
	YES("예"),
	NO("아니오");

	private static final String ERROR_INVALID_OPTION = "잘못된 옵션입니다. 다시 입력해주세요.";
	private final String value;

	Option(final String value) {
		this.value = value;
	}

	public static Option getByValue(String value) {
		return Arrays.stream(Option.values())
			.filter(option -> option.getValue().equals(value))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_OPTION));
	}

	private String getValue() {
		return value;
	}
}
