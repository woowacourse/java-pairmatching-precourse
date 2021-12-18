package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private final String name;

	Level(String name) {
		this.name = name;
	}

	public static String listAsString() {
		List<String> strings = Arrays.stream(values()).sorted()
			.map(Level::toString)
			.collect(Collectors.toList());
		return String.join("\n", strings);
	}

	@Override
	public String toString() {
		List<String> missionNames = Mission.nameListOf(this);
		return "- " + name + ": " + String.join(" | ", missionNames);
	}
}
