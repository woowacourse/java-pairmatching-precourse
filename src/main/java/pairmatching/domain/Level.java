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

	public static Level mappingStringValue(String levelName) {
		return Arrays.stream(Level.values())
			.filter(level -> level.getName().equals(levelName))
			.findFirst()
			.orElseThrow( () -> new IllegalArgumentException("[ERROR] 레벨을 잘 못 입력하셨습니다."));
	}
}
