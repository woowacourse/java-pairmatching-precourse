package pairmatching.controller;

import pairmatching.service.WoowaCourseService;
import pairmatching.view.ViewManager;
import pairmatching.view.clear.ClearOutputView;

public class ClearController implements Controller {

	private final ViewManager viewManager;
	private final WoowaCourseService woowaCourseService;

	public ClearController(ViewManager viewManager, WoowaCourseService woowaCourseService) {
		this.viewManager = viewManager;
		this.woowaCourseService = woowaCourseService;
	}

	@Override

	public void execute() {
		woowaCourseService.clearAll();
		viewManager.output(new ClearOutputView());
	}
}
