package pairmatching;

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
	public String label() {
		return name;
	}
	public static List<String> toArrayname() {
		List<String> result = new ArrayList<>();

		for (Level level: Level.values()) {
			result.add(level.label());
		}
		return result;
	}
	public static Level toEnum(String name) {
		for (Level level: Level.values()) {
			if (level.name.equals(name)) {
				return level;
			}
		}
		return null;
	}
}
