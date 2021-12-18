package pairmatching.domain;

import pairmatching.exception.NotFoundCourseException;
import pairmatching.exception.NotFoundLevelException;

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

	public static Level getLevel(String name) {
		if ("레벨1".equals(name)) {
			return LEVEL1;
		}
		if ("레벨2".equals(name)) {
			return LEVEL2;
		}
		if ("레벨3".equals(name)) {
			return LEVEL3;
		}
		if ("레벨4".equals(name)) {
			return LEVEL4;
		}
		if ("레벨5".equals(name)) {
			return LEVEL5;
		}
		throw new NotFoundLevelException();
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
