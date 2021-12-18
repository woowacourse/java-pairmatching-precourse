package pairmatching.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import pairmatching.domain.PairMatching;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	private PairMatching pairMatching = new PairMatching();
	private OutputView outputView = new OutputView(pairMatching);

	public PairMatchingController() throws IOException {
	}

	public void run() {
		initMainMenu();
		String menuKey = InputView.inputMainMenu();
		if (menuKey.equals("1")) {
			outputView.printPairMatchingInfo();
			while (true) {
				if (createPairMatching()) {
					break;
				}
			}
			run();
		}
		if (menuKey.equals("Q")) {
			return;
		}
	}

	private boolean createPairMatching() {
		List<String> infoForMatching = Arrays.asList(InputView.inputRollLevelAndMission().split(", "));
		String roll = infoForMatching.get(0);
		String level = infoForMatching.get(1);

		if (pairMatching.doesNotExistMatchingInfo(level)) {
			makePair(roll, level);
			return true;
		}
		String answer = InputView.alreadyInformationExist();
		if (answer.equals("네")) {
			makePair(roll, level);
			return true;
		}
		System.out.println();
		return false;
	}

	public void makePair(String roll, String level) {
		pairMatching.makeRandomMatching(roll, level);
		outputView.printMatchingResult(roll, level);
	}

	public void initMainMenu() {
		outputView.printMainMenu();
	}

}
