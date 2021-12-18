package pairmatching.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private String name;
	private static final int INT_INDEX = 2;

	Level(String name) {
		this.name = name;
	}

	public static HashMap<String, List<String>> generateAllLevels() {
		HashMap<String, List<String>> allCourses = new HashMap<>();
		for (Level eachLevel : Level.values()) {
			List<String> missionList = Arrays.stream(Mission.values())
				.filter(eachMission -> eachMission.equalLevel(eachLevel.name.charAt(INT_INDEX) - '0'))
				.map(eachMission -> eachMission.getName())
				.collect(
					Collectors.toList());
			allCourses.put(eachLevel.name, missionList);
		}
		return allCourses;
	}
}