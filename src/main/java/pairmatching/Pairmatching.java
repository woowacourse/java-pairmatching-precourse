package pairmatching;

import pairmatching.input.UserInput;
import pairmatching.model.*;
import pairmatching.service.CourseDataService;
import pairmatching.service.FileService;
import pairmatching.service.MatchService;
import pairmatching.view.Viewer;

import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.input.UserInput.*;
import static pairmatching.model.Error.NOT_MISSION_IN_LEVEL;

public class Pairmatching {

	private CourseDataService courseDataService = new CourseDataService();
	private FileService fileService = new FileService();
	private MatchService matchService = new MatchService();
	private Viewer viewer = new Viewer();
	private UserInput input = new UserInput();

	public void run() {
		LevelMissionsMap levelMissionsMap = courseDataService.initLevelAndMissions();
		Function function = getFunction();
		while (function != Function.QUIT) {
			if (function == Function.MATCH) {
				runMatch(levelMissionsMap);
			} else if (function == Function.SEARCH) {
				runSearch(levelMissionsMap);
			} else if (function == Function.RESET) {
				resetMatch();
			}
			function = getFunction();
		}
		return;
	}

	private void saveMatchResult(String fileName, List<String> crewPairs) {
		String result = crewPairs.stream().collect(Collectors.joining("\n"));
		fileService.saveCrewMatchResult(fileName, result);
	}

	private Function getFunction() {
		Function function = Function.QUIT;
		try {
			viewer.showFunctions();
			function = input.getFunction();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			getFunction();
		}
		return function;
	}

	private void runMatch(LevelMissionsMap levelMissionsMap) {
		try {
			viewer.showCourseAndMissions(levelMissionsMap);
			List<String> inputs = input.getCourseLevelMission();
			Course course = Course.getCourseByName(inputs.get(COURSE_INDEX));
			Level level = Level.getLevelByName(inputs.get(LEVEL_INDEX));
			Mission mission = Mission.getMissionByName(inputs.get(MISSION_INDEX));
			checkMissionInLevel(levelMissionsMap, level, mission);
			List<String> crewNames = fileService.readCrewNamesFromFile(course);
			List<String > randomMatch = matchService.getRandomMatch(crewNames);
			viewer.showCrewPairs(randomMatch);
			saveMatchResult(getMatchFileName(course, level, mission), randomMatch);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			runMatch(levelMissionsMap);
		}
	}

	private void runSearch(LevelMissionsMap levelMissionsMap) {
		try {
			viewer.showCourseAndMissions(levelMissionsMap);
			List<String> inputs = input.getCourseLevelMission();
			Course course = Course.getCourseByName(inputs.get(COURSE_INDEX));
			Level level = Level.getLevelByName(inputs.get(LEVEL_INDEX));
			Mission mission = Mission.getMissionByName(inputs.get(MISSION_INDEX));
			fileService.readMatch(getMatchFileName(course, level, mission));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			runSearch(levelMissionsMap);
		}
	}

	private void resetMatch() {
		fileService.deleteMatchFiles();
	}

	private boolean checkAlreadyMatched(String fileName) {
		return fileService.checkFileExist(fileName);
	}

	private String getMatchFileName(Course course, Level level, Mission mission) {
		return course.toString() + "_" + level.toString() + "_" + mission.toString() + ".md";
	}

	private void checkMissionInLevel(LevelMissionsMap levelMissionsMap, Level level, Mission mission) {
		if (!levelMissionsMap.isMissionInLevel(level, mission)) {
			throw new IllegalArgumentException(NOT_MISSION_IN_LEVEL);
		}
	}
}