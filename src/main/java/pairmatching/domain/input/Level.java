package pairmatching.domain.input;

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
		return this.name;
	}

	public static Level fromLevelName(String courseName) {
		Level[] levels = values();
		return Arrays.stream(levels)
			.filter(functionType -> functionType.getName().equals(courseName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("해당 레벨은 존재하지 않습니다."));
	}
}
