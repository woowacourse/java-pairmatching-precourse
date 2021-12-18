package pairmatching.controller;

import pairmatching.domain.PairMatching;
import pairmatching.domain.WoowaCourse;
import pairmatching.service.PairMatchingService;
import pairmatching.service.ParseService;
import pairmatching.service.WoowaCourseService;
import pairmatching.view.ViewManager;
import pairmatching.view.common.CommonErrorView;
import pairmatching.view.common.CommonOutputView;
import pairmatching.view.match.MatchInputView;
import pairmatching.view.match.RematchInputView;
import pairmatching.view.match.SearchOutputView;

public class MatchController implements Controller {

	private final ViewManager viewManager;
	private final ParseService parseService;
	private final WoowaCourseService woowaCourseService;
	private final PairMatchingService pairMatchingService;

	public MatchController(ViewManager viewManager, ParseService parseService,
		WoowaCourseService woowaCourseService, PairMatchingService pairMatchingService) {
		this.viewManager = viewManager;
		this.parseService = parseService;
		this.woowaCourseService = woowaCourseService;
		this.pairMatchingService = pairMatchingService;
	}

	@Override
	public void execute() {
		try {
			String input = viewManager.input(new MatchInputView());
			WoowaCourse woowaCourse = parseService.parseWoowaCourse(input);
			if (alreadyExists(woowaCourse) && !userWantRematch()) {
				return;
			}
			match(woowaCourse);
		} catch (IllegalArgumentException e) {
			viewManager.error(new CommonErrorView(e.getMessage()));
			execute();
		}
	}

	private void match(WoowaCourse woowaCourse) {
		PairMatching pairMatching = new PairMatching(pairMatchingService.pairMatch(woowaCourse));
		woowaCourseService.matchAndEnroll(woowaCourse, pairMatching);
		viewManager.output(new SearchOutputView(pairMatching.toString()));
	}

	private boolean alreadyExists(WoowaCourse woowaCourse) {
		return woowaCourseService.isDuplicated(woowaCourse);
	}

	private boolean userWantRematch() {
		try {
			String rematch = viewManager.input(new RematchInputView());
			return parseService.parseRematch(rematch);
		} catch (IllegalArgumentException e) {
			viewManager.error(new CommonErrorView(e.getMessage()));
			return userWantRematch();
		}
	}
}
