package pairmatching.controller;

import pairmatching.domain.Match;
import pairmatching.domain.MatchingInformation;
import pairmatching.service.InputService;
import pairmatching.validator.MatchValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
	public void pairMatching() {
		makeMatch(getInformation());
	}

	private MatchingInformation getInformation() {
		MatchingInformation information;
		InputView.inputMatching();
		try {
			information = MatchingInformation.of(InputService.input(new MatchValidator()));
		} catch (IllegalArgumentException exception) {
			OutputView.errorView(exception.getMessage());
			information = getInformation();
		}
		return information;
	}

	private void makeMatch(MatchingInformation matchingInformation) {
		OutputView.matchView(Match.of(matchingInformation));
	}
}
