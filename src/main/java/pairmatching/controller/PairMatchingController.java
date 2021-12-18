package pairmatching.controller;

import pairmatching.service.PairMatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	OutputView outputView = new OutputView();
	InputView inputView = new InputView();
	PairMatchingService pairMatchingService = new PairMatchingService();

	public void start() {
		outputView.showCourseInfo();
		while (true) {
			try {
				pairMatchingService.start(inputView.getCourseInfo());
				return;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
