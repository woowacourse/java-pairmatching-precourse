package pairmatching.service;

import pairmatching.model.Course;
import pairmatching.model.CourseLevelMission;
import pairmatching.model.Level;
import pairmatching.model.MatchingPairs;
import pairmatching.model.Mission;

public class InquiringService {
	public String inquire(CourseLevelMission courseLevelMission) {
		Course course = courseLevelMission.getCourse();
		Level level = courseLevelMission.getLevel();
		Mission mission = courseLevelMission.getMission();

		MatchingPairs matchingPairs = mission.getMatchingPairs().shuffle();

		return matchingPairs.toString();
	}
}
