package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum Level {
	LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
	LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
	LEVEL3("레벨3"),
	LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
	LEVEL5("레벨5");

	private static final String ERROR_MESSAGE_NO_MISSION = "해당 레벨에 미션이 없습니다.";

	private String name;
	private List<String> missions;

	Level(String name) {
		this.name = name;
	}

	Level(String name, List<String> missions) {
		this.name = name;
		this.missions = missions;
	}

	public static boolean isContainMission(String inputLevel, String inputMission) {
		List<String> missionList = from(inputLevel).missions;
		for (String mission : missionList) {
			if (mission.equals(inputMission)) {
				return true;
			}
		}
		return false;
	}

	public static Level from(String inputLevel) {
		return Stream.of(Level.values())
			.filter(level -> level.getName().equals(inputLevel))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_NO_MISSION));
	}

	public String getName() {
		return name;
	}

	public List<String> getMissions() {
		return missions;
	}
}