package pairmatching.utils.validator;

import static pairmatching.utils.Constants.*;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.repository.MissionRepository;

public class InputValidator {
	public static void validateInputPairMatching(String course, String level, String mission) {
		Course.find(course);
		Level.find(level);
		MissionRepository.findMission(mission);
	}

	public static void validateInputRequestRematching(String input) {
		if (!(input.equals("네") || input.equals("아니오"))) {
			throw new IllegalArgumentException(ERROR_MESSAGE + "네 or 아니오로만 입력해야 합니다.");
		}
	}
}
