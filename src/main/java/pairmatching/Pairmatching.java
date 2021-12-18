package pairmatching;

import pairmatching.input.UserInput;
import pairmatching.model.*;
import pairmatching.service.CourseDataService;
import pairmatching.service.FileService;
import pairmatching.service.MatchService;
import pairmatching.view.Viewer;

import java.util.List;

import static pairmatching.input.UserInput.*;

public class Pairmatching {

	private CourseDataService courseDataService = new CourseDataService();
	private FileService fileService = new FileService();
	private MatchService matchService = new MatchService();
	private Viewer viewer = new Viewer();
	private UserInput input = new UserInput();

	public void run() {
		LevelMissionsMap levelMissionsMap = courseDataService.initLevelAndMissions();
		viewer.showFunctions();
		Function function = input.getFunction();
		if (function == Function.MATCH || function == Function.SEARCH) {
			viewer.showCourseAndMissions(levelMissionsMap);
			List<String> inputs = input.getCourseLevelMission();
			Course course = Course.getCourseByName(inputs.get(COURSE_INDEX));
			Level level = Level.getLevelByName(inputs.get(LEVEL_INDEX));
			Mission mission = Mission.getMissionByName(inputs.get(MISSION_INDEX));
			List<String> crewNames = fileService.readCrewNamesFromFile(Course.BACKEND);
			List<CrewPair> randomMatch = matchService.getRandomMatch(crewNames);
			viewer.showCrewPairs(randomMatch);
			saveMatchResult(course.toString() + "_" + level.toString() + "_" + mission.toString() + ".md", randomMatch);
		}

	}

	private void saveMatchResult(String fileName, List<CrewPair> crewPairs) {
		fileService.saveCrewMatchResult(fileName, crewPairs);
	}
}
