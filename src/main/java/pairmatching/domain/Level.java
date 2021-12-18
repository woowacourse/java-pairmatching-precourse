package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pairmatching.view.ErrorMessage;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private final String name;
	private final List<String> missions;

	Level(String name) {
		this.name = name;
		this.missions = setMissions(name);
	}

	private List<String> setMissions(String name) {
		if (name.equals("레벨1")) {
			return Arrays.asList("자동차경주", "로또", "숫자야구게임");
		}
		if (name.equals("레벨2")) {
			return Arrays.asList("장바구니", "결제", "지하철노선도");
		}
		if (name.equals("레벨4")) {
			return Arrays.asList("성능개선", "배포");
		}
		return new ArrayList<>();
	}

	private String getName() {
		return name;
	}

	private List<String> getMissions() {
		return missions;
	}

	public static Level getLevel(String name) {
		return Arrays.stream(values())
			.filter(level -> level.getName().equals(name))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_LEVEL_NAME));
	}

	public static boolean isExistingLevel(String inputLevel) {
		return Arrays.stream(values())
			.map(Level::getName)
			.anyMatch(name -> name.equals(inputLevel));
	}

	public static boolean isExistingMission(String name, String inputMission) {
		return getLevel(name).getMissions()
			.stream()
			.anyMatch(mission -> mission.equals(inputMission));
	}
}
