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
		List<String> matchingConditions = inputMainMenu();
		createPairMatching(matchingConditions);
	}

	private List<String> inputMainMenu() {
		outputView.printMainMenu();
		InputView.inputMainMenu();
		outputView.printPairMatchingInfo();
		String inputMatchingCondition = InputView.inputRollLevelAndMission();
		List<String> conditions = Arrays.asList(inputMatchingCondition.split(", "));
		return conditions;
	}

	private void createPairMatching(List<String> matchingConditions) {
		String roll = matchingConditions.get(0);
		String level = matchingConditions.get(1);
		String mission = matchingConditions.get(2);
		pairMatching.makeRandomMatching(roll, level);
		pairMatching.makeRandomMatching(roll, "레벨2");
	}
}
