package pairmatching.controller;

import pairmatching.domain.MatchingInformation;
import pairmatching.service.InputService;
import pairmatching.validator.MatchValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
	public void pairMatching() {
		InputView.inputMatching();
		try {
			MatchingInformation.of(InputService.input(new MatchValidator()));
		} catch (IllegalArgumentException exception) {
			OutputView.errorView(exception.getMessage());
			pairMatching();
		}
	}
}
