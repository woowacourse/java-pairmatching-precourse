package pairmatching;

import pairmatching.model.Level;
import pairmatching.model.LevelMissionsMap;
import pairmatching.service.CourseDataService;
import pairmatching.view.Viewer;

public class Pairmatching {

	private CourseDataService courseDataService = new CourseDataService();
	private Viewer viewer = new Viewer();

	public void run() {
		LevelMissionsMap levelMissionsMap = courseDataService.initLevelAndMissions();
		viewer.showFunctions();
	}
}
