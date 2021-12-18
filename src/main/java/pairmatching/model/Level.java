package pairmatching.model;

import java.util.Arrays;
import java.util.stream.Stream;

import pairmatching.exception.LevelException;

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
	public boolean isSameName(String name){
		return this.name.equals(name);
	}

	public static Level findLevelByName(String levelName) {
		return Arrays.stream(Level.values()).filter(
			level -> level.getName().equals(levelName)
		).findFirst().orElseThrow(LevelException::new);
	}
}
