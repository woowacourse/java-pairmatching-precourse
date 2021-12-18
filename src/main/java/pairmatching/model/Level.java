package pairmatching.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {
	LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
	LEVEL2("레벨2", Collections.emptyList()),
	LEVEL3("레벨3", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
	LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
	LEVEL5("레벨5", Collections.emptyList());

	private String name;
	private List<String> missions;

	Level(String name, List<String> missions) {
		this.name = name;
		this.missions = missions;
	}

	public String getName() {
		return name;
	}

	public List<String> getMissions() {
		return missions;
	}

	public static Level findLevelByString(String input) {
		for (Level level:
			 Level.values()) {
			if (level.getName().equals(input)) {
				return level;
			}
		}
		return null;
	}
}
