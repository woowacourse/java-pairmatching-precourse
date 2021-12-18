package pairmatching.pair;

import pairmatching.Course;
import pairmatching.Level;
import pairmatching.Mission;

public class PairTarget {
	private static final String ERROR_INPUT_FORMAT = "과정, 레벨, 미션 형태로 입력해야 합니다.";
	private static final String DELIMITER = ", ";
	private static final int NUMBER_OF_INPUT_COLUMN = 3;
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;

	private Course course;
	private Level level;
	private Mission mission;

	public void validate(String inputPairTarget) {
		validateFormat(inputPairTarget);
		validateTargets(inputPairTarget);
	}

	private void validateFormat(String inputPairTarget) {
		String[] pairTargets = inputPairTarget.split(DELIMITER);
		if (pairTargets.length != NUMBER_OF_INPUT_COLUMN) {
			throw new IllegalArgumentException(ERROR_INPUT_FORMAT);
		}
	}

	private void validateTargets(String inputPairTarget) {
		String[] targets = inputPairTarget.split(DELIMITER);
		course = Course.validateChoose(targets[COURSE_INDEX]);
		level = Level.validateChoose(targets[LEVEL_INDEX]);
		mission = Mission.validateChoose(targets[MISSION_INDEX]);
		mission.validateMissionWithLevel(level);
	}

	public boolean isBackend() {
		return course == Course.BACKEND;
	}

	public boolean isFrontend() {
		return course == Course.FRONTEND;
	}

	public boolean isSameLevel(PairTarget pairTarget) {
		return this.level.equals(pairTarget.level);
	}

	public boolean isSame(PairTarget pairTarget) {
		return this.level.equals(pairTarget.level) && pairTarget.course.equals(this.course)
			&& pairTarget.mission.equals(this.mission);
	}
}

