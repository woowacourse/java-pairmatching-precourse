package pairmatching.model.enums;

import java.util.Arrays;

public enum Level {
	LEVEL_1("레벨1"),
	LEVEL_2("레벨2"),
	LEVEL_3("레벨3"),
	LEVEL_4("레벨4"),
	LEVEL_5("레벨5");

	private String level;

	Level(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "  - " + level + ": ";
	}

	public static Level getLevelByInput(String input) {
		return Arrays.stream(Level.values())
			.filter(level -> level.level.equals(input))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력한 레벨은 존재하지 않습니다."));
	}
}
