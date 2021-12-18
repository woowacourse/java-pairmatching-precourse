package pairmatching.service;

import pairmatching.model.Course;
import pairmatching.model.CourseLevelMission;
import pairmatching.model.Level;
import pairmatching.model.MatchingPairs;
import pairmatching.model.Mission;

public class InquiringService {
	private static final String ERR_PAIR_EMPTY = "[ERROR] 매칭 정보가 존재하지 않습니다";

	public String inquire(CourseLevelMission courseLevelMission) {
		Course course = courseLevelMission.getCourse();
		Level level = courseLevelMission.getLevel();
		Mission mission = courseLevelMission.getMission();

		if (mission.getMatchingPairs() == null) {
			throw new IllegalArgumentException(ERR_PAIR_EMPTY);
		}

		MatchingPairs matchingPairs = mission.getMatchingPairs().shuffle();

		return matchingPairs.toString();
	}
}
