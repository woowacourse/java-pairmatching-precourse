package pairmatching.domain;

import java.util.Arrays;

import pairmatching.constant.Notification;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private final String title;

	Level(String title) {
		this.title = title;
	}

	public static Level getByTitle(String levelTitle) {
		return Arrays.stream(values())
			.filter(level -> level.title.equals(levelTitle))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(Notification.NOT_SUPPORTED_LEVEL.getMessage()));
	}

	public String getTitle() {
		return title;
	}
}
