package pairmatching.controller;

import pairmatching.domain.Match;
import pairmatching.domain.MatchRepository;
import pairmatching.domain.MatchingInformation;
import pairmatching.service.InputService;
import pairmatching.service.MatchService;
import pairmatching.validator.MatchValidator;
import pairmatching.validator.Validator;
import pairmatching.validator.YesOrNoValidator;
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

	public void searchMatch() {
		Match match = null;
		try {
			match = MatchRepository.getMatchByInformation(getInformation());
		} catch (IllegalArgumentException exception) {
			OutputView.errorView(exception.getMessage());
			searchMatch();
		}
		OutputView.matchView(match);
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
		checkContains(matchingInformation);
		Match match = Match.of(matchingInformation);
		OutputView.matchView(match);
		return match;
	}

	private void checkContains(MatchingInformation matchingInformation) {
		if (MatchService.isContainInformation(matchingInformation)) {
			InputView.reinputMatch();
			if (InputService.input(new YesOrNoValidator()).equals("아니오")) {
				throw new IllegalArgumentException("다시 입력해주세요");
			}
		}
	}
}
