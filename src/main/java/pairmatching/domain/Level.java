package pairmatching.domain;

import java.util.Arrays;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private static final String ERROR_OF = "해당하는 레벨이 없습니다.";
	private String name;

	Level(String name) {
		this.name = name;
	}

	public static Level of(String str) {
		return Arrays.stream(values())
			.filter(level -> level.name.equals(str))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_OF));
	}

	// 추가 기능 구현
}
