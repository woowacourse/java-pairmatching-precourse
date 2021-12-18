package pairmatching.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.course.Course;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.level.Level;
import pairmatching.domain.pair.Pairs;
import pairmatching.exception.InvalidFormatException;
import pairmatching.exception.NoCourseException;
import pairmatching.exception.NoLevelException;
import pairmatching.exception.NoMissionException;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MissionRepository;
import pairmatching.repository.PairsRepository;
import pairmatching.util.FormatChecker;
import pairmatching.util.InputParser;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
	private static final String LEVEL_MISSIONS_FORMAT = "%s: %s";

	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;

	public void startMatching() {
		try {
			showOverview();
			List<String> courseLevelMission = getCourseLevelMission();
			createRandomPairs(
				Course.getByName(courseLevelMission.get(COURSE_INDEX)),
				Level.getByName(courseLevelMission.get(LEVEL_INDEX)),
				courseLevelMission.get(MISSION_INDEX)
			);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			startMatching();
		}
	}

	private void validateCourseLevelMissionFormat(String input) {
		boolean isFormatValid = FormatChecker.validateCourseLevelMissionInputFormat(input);
		if (!isFormatValid) {
			throw new InvalidFormatException();
		}
	}

	private void validateCourseLevelMission(List<String> courseLevelMission) {
		// TODO: 검증 해야함
		if (!Course.containsName(courseLevelMission.get(COURSE_INDEX))) {
			throw new NoCourseException();
		}

		if (!Level.containsName(courseLevelMission.get(LEVEL_INDEX))) {
			throw new NoLevelException();
		}

		Level level = Level.getByName(courseLevelMission.get(LEVEL_INDEX));
		if (!MissionRepository.contains(level, courseLevelMission.get(MISSION_INDEX))) {
			throw new NoMissionException();
		}
	}

	private void createRandomPairs(Course course, Level level, String mission) {
		// TODO: 겹칠경우 최대 3번 반복하는 로직 추가해야함.
		List<Crew> crews = new ArrayList<>();
		if (course == Course.BACKEND) {
			crews = CrewRepository.getBackend();
		} else if (course == Course.FRONTEND) {
			crews = CrewRepository.getFrontend();
		}

		Pairs pairs = Pairs.createRandom(course, level, mission, crews);
		PairsRepository.create(pairs);
	}

	public void startView() {
		try {
			showOverview();
			List<String> courseLevelMission = getCourseLevelMission();
			showPairMatching(courseLevelMission);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			startMatching();
		}
	}

	private void showPairMatching(List<String> courseLevelMission) {
		Course course = Course.getByName(courseLevelMission.get(COURSE_INDEX));
		Level level = Level.getByName(courseLevelMission.get(LEVEL_INDEX));
		String mission = courseLevelMission.get(MISSION_INDEX);
		Pairs pairs = PairsRepository.find(course, level, mission);

		OutputView.printPairMatching(pairs);
	}

	public void startClear() {
		OutputView.printClear();
		PairsRepository.clear();
	}

	private void showOverview() {
		List<String> levelMissions = Arrays.stream(Level.values())
			.map(level -> String.format(LEVEL_MISSIONS_FORMAT, level.getName(), MissionRepository.findMissions(level)))
			.collect(Collectors.toList());
		List<String> courses = Arrays.stream(Course.values())
			.map(Course::getName)
			.collect(Collectors.toList());

		OutputView.printOverview(courses, levelMissions);
	}

	private List<String> getCourseLevelMission() {
		String input = InputView.inputCourseLevelMission();
		validateCourseLevelMissionFormat(input);

		List<String> courseLevelMission = InputParser.parseCourseLevelMission(input);
		validateCourseLevelMission(courseLevelMission);

		return courseLevelMission;
	}
}
