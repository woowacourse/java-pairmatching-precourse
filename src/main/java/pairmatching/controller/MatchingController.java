package pairmatching.controller;

import pairmatching.service.InputService;
import pairmatching.validator.MatchValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
	public void pairMatching() {
		InputView.inputMatching();
		InputService.input(new MatchValidator());
	}
}
