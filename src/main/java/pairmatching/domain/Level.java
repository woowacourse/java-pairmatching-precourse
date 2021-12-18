package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

public enum Level {
	LEVEL1("레벨1", Arrays.asList("자동차 경주", "로또", "숫자야구게임")),
	LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
	LEVEL3("레벨3", Arrays.asList("")),
	LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
	LEVEL5("레벨5", Arrays.asList(""));

	private static final String ERROR_NOT_LEVEL = " 은 등록되지 않은 레벨입니다.";
	private static final String ERROR_NOT_MISSION = " 은 등록되지 않은 미션입니다.";
	private String name;
	private List<String> missions;

	Level(String name, List<String> missions) {
		this.name = name;
		this.missions = missions;
	}

	public static Level findByLevel(String command) {
		return Arrays.stream(Level.values())
			.filter(level -> level.name.equals(command))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_LEVEL));
	}

	public static Level findByMission(String command) {
		return Arrays.stream(Level.values())
			.filter(level -> level.name.equals(command))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_MISSION));
	}
}
