package pairmatching.validator;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.PairInfo;

public class PairValidator {

	private static final String INPUT_LENGTH_ERROR = "[ERROR] 과정, 레벨, 미션 3가지를 입력해야 합니다.";
	private static final String NO_EXIST_COURSE_ERROR = "[ERROR] 해당 과정이 존재하지 않습니다.";
	private static final String NO_EXIST_LEVEL_ERROR = "[ERROR] 해당 레벨이 존재하지 않습니다.";
	private static final String NO_EXIST_MISSION_ERROR = "[ERROR] 해당 미션이 존재하지 않습니다.";
	private static final String NOT_MATCH_LEVEL_MISSION_ERROR = "[ERROR] 미션과 레벨이 일치하지 않습니다.";
	private static final String NOT_EXIST_PAIR_INFO = "[ERROR] 매칭 이력이 없습니다.";

	public void validateLength(String input) {
		if (input.split(", ").length != 3) {
			throw new IllegalArgumentException(INPUT_LENGTH_ERROR);
		}
	}

	public void validateCourse(Course course) {
		if (course == null) {
			throw new IllegalArgumentException(NO_EXIST_COURSE_ERROR);
		}
	}

	private void validateLevel(Level level) {
		if (level == null) {
			throw new IllegalArgumentException(NO_EXIST_LEVEL_ERROR);
		}
	}

	private void validateMission(Mission mission) {
		if (mission == null) {
			throw new IllegalArgumentException(NO_EXIST_MISSION_ERROR);
		}
	}

	public void validateLevelAndMission(Level level, Mission mission) {
		validateLevel(level);
		validateMission(mission);

		if (!Mission.getByLevel(level).contains(mission)) {
			throw new IllegalArgumentException(NOT_MATCH_LEVEL_MISSION_ERROR);
		}
	}

	public void validatePairInfo(PairInfo pairInfo) {
		if (pairInfo == null) {
			throw new IllegalArgumentException(NOT_EXIST_PAIR_INFO);
		}
	}
}
