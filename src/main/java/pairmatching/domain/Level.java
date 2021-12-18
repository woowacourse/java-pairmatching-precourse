package pairmatching.domain;

import java.util.Arrays;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private String name;

	Level(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Level of(String levelName) {
		return Arrays.stream(values())
			.filter(level -> level.getName().equals(levelName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("올바르지 않은 입력 입니다."));
	}
}
