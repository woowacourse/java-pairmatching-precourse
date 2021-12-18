package pairmatching.model;

import java.util.Arrays;
import java.util.stream.Collectors;

import pairmatching.validator.CourseValidator;
import pairmatching.validator.LevelValidator;
import pairmatching.validator.MissionValidator;

public enum Level {
	LEVEL1("레벨1", Missions.init("자동차경주,로또,숫자야구게임")),
	LEVEL2("레벨2", Missions.init("장바구니,결제,지하철노선도")),
	LEVEL3("레벨3", Missions.init("")),
	LEVEL4("레벨4", Missions.init("성능개선,배포")),
	LEVEL5("레벨5", Missions.init("")); //TODO 미션 init에 빈 문자열 넣어도 nullpointerException터지지 않는지 확인

	private String name;
	private Missions missions;

	Level(String name, Missions missions) {
		this.name = name;
		this.missions = missions;
	}

	public String toString() {
		return "- " + name + ": " + missions.toString();
	}

	public String getName() {
		return this.name;
	}

	public Missions getMissions() {
		return missions;
	}

	public Mission getMission(String missionName) throws IllegalArgumentException {
		return this.missions.getMission(missionName);
	}

	public static String getAllLevel() {
		return Arrays.stream(values())
			.map(Level::toString)
			.collect(Collectors.joining("\n"));
	}

	public static Level parse(String name) {
		return Arrays.stream(values())
			.filter(level -> name.equals(level.name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(LevelValidator.ERROR_NOT_EXISTED));
	}


	public static void isValidMission(Level level, String missionName) {
		if (!level.missions.contains(missionName)) {
			throw new IllegalArgumentException(MissionValidator.ERROR_NOT_EXISTED);
		}
	}


}
