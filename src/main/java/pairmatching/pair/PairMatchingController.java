package pairmatching.pair;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.Menu;
import pairmatching.condition.Answer;
import pairmatching.view.ErrorView;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private static final int ZERO = 0;

	private PairMatching pairMatching;
	private Menu menu;

	public PairMatchingController() {
		this.pairMatching = new PairMatching();
	}

	public void start() {
		do {
			chooseMainFeature();
			requestFeature();
			runFeature();
		} while (menu != Menu.QUIT);
	}

	private void chooseMainFeature() {
		InputView.printChooseFeature();
	}

	private void requestFeature() {
		try {
			String inputFeature = Console.readLine();
			Menu.validateChoose(inputFeature);
			menu = Menu.selectMenu(inputFeature);
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.print(illegalArgumentException.getMessage());
			requestFeature();
		}
	}

	private void runFeature() {
		if (menu == Menu.MATCHING) {
			runRandomPairMatching();
			return;
		}
		if (menu == Menu.FIND) {
			runFindPair();
			return;
		}
		if (menu == Menu.RESET) {
			runResetPair();
			return;
		}
	}

	private void runRandomPairMatching() {
		PairTarget pairTarget = new PairTarget();
		InputView.printSelectPairTarget();
		requestPairTarget(pairTarget);
		try {
			validateAlreadyPairs(pairTarget);
		} catch (IllegalArgumentException illegalArgumentException) {
			if (illegalArgumentException.getMessage() != Answer.NO.toString()) {
				ErrorView.print(illegalArgumentException.getMessage());
			}
			runRandomPairMatching();
		}
		pairMatching.repeatMatching(pairTarget);
		OutputView.printMatchingResult(pairMatching.findPairsByPairTarget(pairTarget));
	}

	private void validateAlreadyPairs(PairTarget pairTarget) {
		if (pairMatching.alreadyPairsByPairTarget(pairTarget)) {
			InputView.printAlreadyPair();
			String inputAnswer = Console.readLine();
			Answer answer = Answer.validateChoose(inputAnswer);
			if (answer == Answer.YES) {
				pairMatching.resetPairs(pairTarget);
				return;
			}
			if (answer == Answer.NO) {
				throw new IllegalArgumentException(Answer.NO.toString());
			}
		}
	}

	private void runFindPair() {
		PairTarget pairTarget = new PairTarget();
		InputView.printSelectPairTarget();
		requestPairTarget(pairTarget);
		try {
			List<Pair> pairs = pairMatching.findPairsByPairTarget(pairTarget);
			OutputView.printMatchingResult(pairs);
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.print(illegalArgumentException.getMessage());
			runFindPair();
		}
	}

	private void runResetPair() {
		pairMatching.resetAllMatching();
		OutputView.printResetMatching();
	}

	private void requestPairTarget(PairTarget pairTarget) {
		try {
			String inputPairTarget = Console.readLine();
			pairTarget.validate(inputPairTarget);
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.print(illegalArgumentException.getMessage());
			requestPairTarget(pairTarget);
		}
	}
}
