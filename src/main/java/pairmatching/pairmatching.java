package pairmatching;

import pairmatching.model.LevelMissionsMap;
import pairmatching.service.CourseDataService;

public class pairmatching {

	private CourseDataService courseDataService = new CourseDataService();

	public void run() {
		LevelMissionsMap levelMissionsMap = courseDataService.initLevelAndMissions();
	}
}
