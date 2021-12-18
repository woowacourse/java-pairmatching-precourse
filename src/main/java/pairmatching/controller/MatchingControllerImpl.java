package pairmatching.controller;

import java.util.List;

import pairmatching.domain.FunctionChoice;
import pairmatching.dto.MatchDto;
import pairmatching.exception.MatchDataNotExistException;
import pairmatching.exception.PairMatchingException;
import pairmatching.service.MatchingService;
import pairmatching.view.input.InputView;
import pairmatching.view.input.YesOrNo;
import pairmatching.view.output.OutputView;

public class MatchingControllerImpl implements MatchingController {

	private final MatchingService matchingService;
	private final InputView inputView;
	private final OutputView outputView;

	public MatchingControllerImpl(MatchingService matchingService,
							  InputView inputView, OutputView outputView) {
		this.matchingService = matchingService;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	@Override
	public void run() {
		while (true) {
			outputView.printFunctionChoice();
			try {
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
			} catch (PairMatchingException ex) {
				outputView.printErrorMessage(ex.getMessage());
			}
		}
	}

	@Override
	public void matchPair() {
		outputView.printDetails();
		while (true) {
			outputView.printRequestMatchOptions();
			try {
				MatchDto matchDto = inputView.requestMatchDto();
				if (isRequestAgain(matchDto)) {
					continue;
				}
				List<String> results = matchingService.matchCrews(matchDto);
				outputView.printMatchResult(results);
				break;
			} catch (PairMatchingException ex) {
				outputView.printErrorMessage(ex.getMessage());
			}
		}
	}

	private boolean isRequestAgain(MatchDto matchDto) {
		if (matchingService.isAlreadyMatched(matchDto)) {
			outputView.printRequestYesOrNow();
			outputView.printEmptyNewLine();
			YesOrNo option = inputView.requestYesOrNo();
			return !option.getValue();
		}
		return false;
	}

	@Override
	public void searchPair() {
		outputView.printDetails();
		while (true) {
			outputView.printRequestMatchOptions();
			try {
				MatchDto matchDto = inputView.requestMatchDto();
				if (matchingService.isNotAlreadyMatched(matchDto)) {
					throw new MatchDataNotExistException();
				}
				List<String> results = matchingService.getPairResultOfMatchGroup(matchDto);
				outputView.printMatchResult(results);
				break;
			} catch (PairMatchingException ex) {
				outputView.printErrorMessage(ex.getMessage());
			}
		}
	}

	@Override
	public void resetPair() {
		matchingService.resetMatchGroups();
	}

}
