package pairmatching.model;

import java.util.Arrays;

public enum Level {
	LEVEL_1("레벨1"), LEVEL_2("레벨2"), LEVEL_3("레벨3"), LEVEL_4("레벨4"), LEVEL_5("레벨5");

	private final String name;

	Level(String name) {
		this.name = name;
	}

	public static Level valueByName(String name) {
		return Arrays.stream(values()).filter(l -> l.getName().equals(name)).findFirst().get();
	}

	public String getName() {
		return name;
	}
}
