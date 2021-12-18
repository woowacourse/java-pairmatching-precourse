package pairmatching;

import pairmatching.input.UserInput;
import pairmatching.model.Function;
import pairmatching.model.LevelMissionsMap;
import pairmatching.service.CourseDataService;
import pairmatching.view.Viewer;

public class Pairmatching {

	private CourseDataService courseDataService = new CourseDataService();
	private Viewer viewer = new Viewer();
	private UserInput input = new UserInput();

	public void run() {
		LevelMissionsMap levelMissionsMap = courseDataService.initLevelAndMissions();
		viewer.showFunctions();
		Function function = input.getFunction();
		if (function == Function.MATCH || function == Function.SEARCH) {
			viewer.showCourseAndMissions(levelMissionsMap);
			input.getCourseLevelMission();
		}
	}
}
