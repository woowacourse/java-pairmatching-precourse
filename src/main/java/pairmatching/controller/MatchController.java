package pairmatching.controller;

import pairmatching.domain.WoowaCourse;
import pairmatching.service.ParseService;
import pairmatching.service.WoowaCourseService;
import pairmatching.view.ViewManager;
import pairmatching.view.match.MatchInputView;
import pairmatching.view.match.RematchInputView;

public class MatchController implements Controller {

	private final ViewManager viewManager;
	private final ParseService parseService;
	private final WoowaCourseService woowaCourseService;

	public MatchController(ViewManager viewManager, ParseService parseService,
		WoowaCourseService woowaCourseService) {
		this.viewManager = viewManager;
		this.parseService = parseService;
		this.woowaCourseService = woowaCourseService;
	}

	@Override
	public void execute() {
		String input = viewManager.input(new MatchInputView());
		WoowaCourse woowaCourse = parseService.parseWoowaCourse(input);
		if (alreadyExists(woowaCourse) && rematch()) {
			return;
		}
		match(woowaCourse);
	}

	private void match(WoowaCourse woowaCourse) {
		woowaCourseService.matchAndEnroll(woowaCourse);
	}

	private boolean alreadyExists(WoowaCourse woowaCourse) {
		return woowaCourseService.isDuplicated(woowaCourse);
	}

	private boolean rematch() {
		String rematch = viewManager.input(new RematchInputView());
		return parseService.parseRematch(rematch);
	}
}
