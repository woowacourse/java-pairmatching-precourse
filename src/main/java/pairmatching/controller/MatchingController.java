package pairmatching.controller;

import pairmatching.domain.Match;
import pairmatching.domain.MatchRepository;
import pairmatching.domain.MatchingInformation;
import pairmatching.service.InputService;
import pairmatching.validator.MatchValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
	public void pairMatching() {
		try {
			MatchRepository.enrollMatch(makeMatch(getInformation()));
		} catch (IllegalArgumentException exception) {
			OutputView.errorView(exception.getMessage());
			pairMatching();
		}
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

	private Match makeMatch(MatchingInformation matchingInformation) {
		Match match = Match.of(matchingInformation);
		OutputView.matchView(match);
		return match;
	}
}
