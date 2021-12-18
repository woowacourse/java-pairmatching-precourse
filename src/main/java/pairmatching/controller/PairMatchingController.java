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
		while (true) {
			inputMainMenu();
		}

	}

	public boolean inputMainMenu() {
		outputView.printMainMenu();
		String menuKey = InputView.inputMainMenu();
		if (menuKey.equals("1")) {
			outputView.printPairMatchingInfo();
			ifChoiceIsPairMatching();
			return true;
		}
		if (menuKey.equals("2")) {
			outputView.printPairMatchingInfo();
			String inputMatchingCondition = InputView.inputRollLevelAndMission();
			List<String> conditions = Arrays.asList(inputMatchingCondition.split(", "));

			return true;
		}

	}

	public void ifChoiceIsPairMatching() {
		String inputMatchingCondition = InputView.inputRollLevelAndMission();
		List<String> conditions = Arrays.asList(inputMatchingCondition.split(", "));
		createPairMatching(conditions);
	}

	public void createPairMatching(List<String> matchingConditions) {
		String roll = matchingConditions.get(0);
		String level = matchingConditions.get(1);
		String mission = matchingConditions.get(2);
		if (pairMatching.doesExistMatchingInfo(level)) {
			String answer = InputView.alreadyInformationExist();
			if (answer.equals("네")) {
				pairMatching.makeRandomMatching(roll, level);
				outputView.printMatchingResult(roll, level);
				return;
			}
			System.out.println();
			ifChoiceIsPairMatching();

		}
		pairMatching.makeRandomMatching(roll, level);
		outputView.printMatchingResult(roll, level);

	}
}
