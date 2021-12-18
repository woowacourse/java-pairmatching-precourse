package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	public static Level getLevelByName(String levelName) {
		return getLevels().stream()
			.filter(level -> level.name.equals(levelName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력한 레벨은 존재하지 않습니다."));
	}

	private static List<Level> getLevels() {
		return new ArrayList<>(Arrays.asList(Level.values()));
	}

	public String getName() {
		return name;
	}
}