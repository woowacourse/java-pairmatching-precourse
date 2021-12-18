package pairmatching.Controller.subcontroller;

import pairmatching.Controller.Controller;
import pairmatching.Service.MatchingService;
import pairmatching.view.OutputView;

public class MatchingController implements Controller {
	private final MatchingService matchingService;

	public MatchingController() {
		this.matchingService = new MatchingService();
	}

	@Override
	public void run() {
		OutputView.printMessage(matchingService.printCourseAndLevelInfo());


	}
}
