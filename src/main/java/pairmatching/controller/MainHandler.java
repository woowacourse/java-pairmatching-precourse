package pairmatching.controller;

import java.io.IOException;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Matching;
import pairmatching.domain.MatchingRepository;
import pairmatching.domain.MissionType;
import pairmatching.domain.service.MatchingService;
import pairmatching.view.InputView;

public class MainHandler {
	private static final String COMMAND_SPLIT = ",";
	private static final int COMMAND_SPLIT_LIMIT = -1;
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;

	public static void matchingManager() {
		try {
			final String[] command = InputView.getInputPairMatching().split(COMMAND_SPLIT, COMMAND_SPLIT_LIMIT);
			final Course course = Course.findByCourse(command[COURSE_INDEX]);
			final Level level = Level.findByLevel(command[LEVEL_INDEX]);
			final MissionType missionType = Level.findByMission(command[MISSION_INDEX]);
			matchingProcessJudge(course, level, missionType);
			// 결과 출력
		} catch (IllegalArgumentException | IOException e) {

			matchingManager();
		}
	}

	private static void matchingProcessJudge(Course course, Level level, MissionType missionType) throws IOException {
		boolean validate = isValidateCheckMatching(course, level);

		if (validate == true) {
		}

		if (validate == false) {
		}
	}

	private static boolean isValidateCheckMatching(Course course, Level level) {
		List<Matching> matchings = MatchingRepository.matchings();
		if (isValidateSameCourse(matchings, course) && isValidateSameLevel(matchings, level)) {
			return true;
		}

		return false;
	}

	private static boolean isValidateSameCourse(List<Matching> matchings, Course course) {
		return matchings.stream()
			.anyMatch(matching -> matching.equalsCourse(course));
	}

	private static boolean isValidateSameLevel(List<Matching> matchings, Level level) {
		return matchings.stream()
			.anyMatch(matching -> matching.equalsLevel(level));
	}

	public static void referenceManager() {
	}

	public static void initializationManager() {
	}

	public static void exitManager() {
		return;
	}
}
