package pairmatching.controller;

import pairmatching.domain.FunctionChoice;
import pairmatching.view.input.InputView;

public class MatchingControllerImpl implements MatchingController {

	private final InputView inputView = new InputView();

	@Override
	public void run() {
		while (true) {
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
		}
	}

	@Override
	public void matchPair() {

	}

	@Override
	public void searchPair() {

	}

	@Override
	public void resetPair() {

	}

}
