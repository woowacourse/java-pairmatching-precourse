package pairmatching.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import pairmatching.exception.MissionNotFoundException;
import pairmatching.view.input.Delimiter;
import pairmatching.view.output.OutputMessage;

public enum Level {

	LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
	LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
	LEVEL3("레벨3", Collections.emptyList()),
	LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
	LEVEL5("레벨5", Collections.emptyList());

	private final String level;
	private final List<String> missions;

	Level(String level, List<String> missions) {
		this.level = level;
		this.missions = missions;
	}

	public static Level of(String level, String mission) {
		return Arrays.stream(Level.values())
			.filter(missionGroup -> missionGroup.hasMission(mission))
			.findAny()
			.orElseThrow(MissionNotFoundException::new);
	}

	public boolean hasMission(String missionName) {
		return missions.stream()
			.anyMatch(mission -> mission.equals(missionName));
	}

	public String toString() {
		return String.format(OutputMessage.MISSION_STRING_FORMAT, level, Delimiter.joinWithVerticalLine(missions));
	}

	public String getLevel() {
		return level;
	}

	public boolean isEquals(Level others) {
		return level.equals(others.getLevel());
	}

	public List<String> getMissions() {
		return missions;
	}

}
