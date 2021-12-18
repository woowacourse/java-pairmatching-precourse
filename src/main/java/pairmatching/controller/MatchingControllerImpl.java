package pairmatching.controller;

import java.util.List;

import pairmatching.domain.FunctionChoice;
import pairmatching.domain.YesOrNo;
import pairmatching.dto.MatchDto;
import pairmatching.service.MatchingService;
import pairmatching.service.MatchingServiceImpl;
import pairmatching.view.input.InputView;
import pairmatching.view.output.OutputView;

public class MatchingControllerImpl implements MatchingController {

	private final MatchingService matchingService = new MatchingServiceImpl();
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	@Override
	public void run() {
		while (true) {
			outputView.printFunctionChoice();
			FunctionChoice functionChoice = inputView.requestFunctionChoice();
			switch (functionChoice) {
				case PAIR_MATCH:
					matchPair();
					break;
				case PAIR_SEARCH:
					searchPair();
					break;
				case PAIR_RESET:
					resetPair();
					break;
				case PAIR_QUIT:
					return;
			}
			outputView.printEmptyNewLine();
		}
	}

	@Override
	public void matchPair() {
		outputView.printDetails();
		while (true) {
			outputView.printRequestMatchOptions();
			MatchDto matchDto = inputView.requestMatchDto();
			if (isRequestAgain(matchDto)) {
				continue;
			}
			List<String> results = matchingService.matchCrews(matchDto);
			outputView.printMatchResult(results);
			break;
		}
	}

	private boolean isRequestAgain(MatchDto matchDto) {
		if (matchingService.isAlreadyMatched(matchDto)) {
			outputView.printRequestYesOrNow();
			outputView.printEmptyNewLine();
			YesOrNo option = inputView.requestYesOrNo();
			return option.getValue();
		}
		return false;
	}

	@Override
	public void searchPair() {

	}

	@Override
	public void resetPair() {

	}

}
