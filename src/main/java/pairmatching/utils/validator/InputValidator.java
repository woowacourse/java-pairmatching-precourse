package pairmatching.utils.validator;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.repository.MissionRepository;

public class InputValidator {
	public static void validateInputPairMatching(String course, String level, String mission) {
		Course.find(course);
		Level.find(level);
		MissionRepository.findMission(mission);
	}
}
