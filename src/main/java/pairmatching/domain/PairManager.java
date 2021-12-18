package pairmatching.domain;

import pairmatching.Function;

public class PairManager {
	private static final String ERROR_MISSION_NOT_IN_LEVEL = "해당 레벨의 미션이 아닙니다.";

	public void runFunction(Course course, Level level, Mission mission, Function function) {
		validateMission(level, mission);
	}

	private void validateMission(Level level, Mission mission) {
		if (!mission.isLevel(level)) {
			throw new IllegalArgumentException(ERROR_MISSION_NOT_IN_LEVEL);
		}
	}
}
