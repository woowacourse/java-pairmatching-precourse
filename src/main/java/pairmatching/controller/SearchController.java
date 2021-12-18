package pairmatching.controller;

import pairmatching.domain.WoowaCourse;
import pairmatching.service.ParseService;
import pairmatching.service.WoowaCourseService;
import pairmatching.view.ViewManager;
import pairmatching.view.common.CommonErrorView;
import pairmatching.view.match.MatchInputView;
import pairmatching.view.match.SearchOutputView;

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
		try {
			String input = viewManager.input(new MatchInputView());
			WoowaCourse woowaCourse = parseService.parseWoowaCourse(input);
			viewManager.output(new SearchOutputView(woowaCourseService.getPairMatch(woowaCourse)));
		} catch (IllegalArgumentException e) {
			viewManager.error(new CommonErrorView(e.getMessage()));
			execute();
		}
	}
}
