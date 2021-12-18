package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.validator.CourseValidator;

public enum Course {
	BACKEND("백엔드", Arrays.asList(Level.values())),
	FRONTEND("프론트엔드", Arrays.asList(Level.values()));

	private String name;
	private List<Level> levelList;

	Course(String name, List<Level> levelList) {
		this.name = name;
		this.levelList = levelList;
	}

	public List<Level> getLevelList() {
		return this.levelList;
	}

	public Level getLevel(String levelName) {
		return this.levelList.stream().filter(level -> levelName.equals(level.getName())).findFirst().get();
	}

	public static String getAllCourse() {
		return Arrays.stream(values()).map(it -> it.name).collect(Collectors.joining(" | "));
	}

	public static Course parse(String name) {
		return Arrays.stream(values())
			.filter(course -> name.equals(course.name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(CourseValidator.ERROR_NOT_EXISTED));
	}
}
