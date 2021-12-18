package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.ErrorView;
import pairmatching.view.InputView;

public class PairMatchingController {
	private Menu menu;

	public void start() {
		chooseMainFeature();
		requestFeature();
		while (menu != Menu.QUIT) {
			runFeature();
		}
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
	}

	private void runFindPair() {
		PairTarget pairTarget = new PairTarget();
		InputView.printSelectPairTarget();
		requestPairTarget(pairTarget);
	}

	private void runResetPair() {

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
