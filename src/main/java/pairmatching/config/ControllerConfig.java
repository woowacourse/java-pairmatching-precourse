package pairmatching.config;

import pairmatching.controller.ClearController;
import pairmatching.controller.Controller;
import pairmatching.controller.MatchController;
import pairmatching.controller.SearchController;

public class ControllerConfig {
	public static Controller getMatchController() {
		return new MatchController(
			ViewManagerConfig.getViewManager(),
			ServiceConfig.getParseService(),
			ServiceConfig.getWoowaCourseService(),
			ServiceConfig.getPairMatchingService()
		);
	}

	public static Controller getClearController() {
		return new ClearController(
			ViewManagerConfig.getViewManager(),
			ServiceConfig.getWoowaCourseService()
		);
	}

	public static Controller getSearchController() {
		return new SearchController(
			ViewManagerConfig.getViewManager(),
			ServiceConfig.getParseService(),
			ServiceConfig.getWoowaCourseService()
		);
	}
}
