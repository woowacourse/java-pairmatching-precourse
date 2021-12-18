package pairmatching.model;

import java.util.List;
import java.util.stream.Collectors;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5");

	private String name;
	private List<Mission> missions;

	Level(String name) {
		this.name = name;
	}

	// 추가 기능 구현

	public static Level getLevelByString(String levelString) {
		if (levelString.equals("레벨1")) {
			return LEVEL1;
		}
		if (levelString.equals("레벨2")) {
			return LEVEL2;
		}
		if (levelString.equals("레벨3")) {
			return LEVEL3;
		}
		if (levelString.equals("레벨4")) {
			return LEVEL4;
		}
		return LEVEL5;
	}

	public String getName() {
		return name;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void missionInit(List<Mission> missions) {
		this.missions = missions;
	}

	@Override
	public String toString() {
		List<String> missionNames = missions.stream()
			.map(Mission::getName)
			.collect(Collectors.toList());
		String missionsString = String.join(" | ", missionNames);
		return "- " + name + ": " + missionsString;
	}
}
