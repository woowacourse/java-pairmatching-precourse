package pairmatching.controller;

import pairmatching.domain.WoowaCourse;
import pairmatching.service.ParseService;
import pairmatching.service.WoowaCourseService;
import pairmatching.view.ViewManager;
import pairmatching.view.common.CommonOutputView;
import pairmatching.view.match.MatchInputView;

public class SearchController implements Controller {

	private final ViewManager viewManager;
	private final ParseService parseService;
	private final WoowaCourseService woowaCourseService;

	public SearchController(ViewManager viewManager, ParseService parseService,
		WoowaCourseService woowaCourseService) {
		this.viewManager = viewManager;
		this.parseService = parseService;
		this.woowaCourseService = woowaCourseService;
	}

	@Override
	public void execute() {
		String input = viewManager.input(new MatchInputView());
		WoowaCourse woowaCourse = parseService.parseWoowaCourse(input);
		viewManager.output(new CommonOutputView(woowaCourseService.getPairMatch(woowaCourse)));
	}
}
