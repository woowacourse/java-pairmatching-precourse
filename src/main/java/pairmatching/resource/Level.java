package pairmatching.resource;

import static pairmatching.constants.ProgramConstants.*;

import java.util.Arrays;
import java.util.List;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5"),
	;

	private String name;

	Level(String name) {
		this.name = name;
	}

	public static String getLevelOptions() {
		StringBuilder courseOptions = new StringBuilder("미션:\n");
		for (String level : MISSION_MAP.keySet()) {
			courseOptions.append(String.format("\t- %s: %s\n", level, getMissionsByLevel(level)));
		}
		return courseOptions.toString();
	}

	private static String getMissionsByLevel(String level) {
		return String.join(" | ", MISSION_MAP.get(level));
	}

	public static List<String> toList() {
		return Arrays.asList("레벨1", "레벨2", "레벨3", "레벨4", "레벨5");
	}
}

