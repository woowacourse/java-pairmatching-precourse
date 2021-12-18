package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Level {
	LEVEL_1("레벨1", 1),
	LEVEL_2("레벨2", 2),
	LEVEL_3("레벨3", 3),
	LEVEL_4("레벨4", 4),
	LEVEL_5("레벨5", 5);

	private String name;
	private int level;

	Level(String name, int level) {
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public static List<Level> getLevelList() {
		return Stream.of(Level.values()).collect(Collectors.toList());
	}

}
