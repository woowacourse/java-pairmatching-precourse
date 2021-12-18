package pairmatching.Controller.subcontroller;

import pairmatching.Controller.Controller;
import pairmatching.Service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController implements Controller {
	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();

	private final MatchingService matchingService;

	public MatchingController() {
		this.matchingService = new MatchingService();
	}

	@Override
	public void run() {
		outputView.printMessage(matchingService.printCourseAndLevelInfo());


	}
}
