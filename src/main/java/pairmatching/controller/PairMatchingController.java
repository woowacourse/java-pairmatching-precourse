package pairmatching.controller;

import pairmatching.view.Print;
import pairmatching.serivce.PairMatching;
import pairmatching.type.PairMatchingType;

import static pairmatching.view.Input.*;

public class PairMatchingController {
	private PairMatching pairMatching;

	public PairMatchingController(PairMatching pairMatching) {
		this.pairMatching = pairMatching;
	}

	public void start() {
		readCrews();
		selectFunction();
	}

	private void readCrews() {
		pairMatching.setCrews();
	}

	private void selectFunction() {
		Print.printSelectFunction();
		String input = inputFunction();
		if (input.equalsIgnoreCase(PairMatchingType.QUIT.getString())) {
			return;
		}

		int function = Integer.parseInt(input);
		if (function == PairMatchingType.MATCH.getNumber()) {
			pairMatching();
		} else if (function == PairMatchingType.VIEW.getNumber()) {
			// TODO: 조회
		} else if (function == PairMatchingType.RESET.getNumber()) {
			// TODO: 초기화
		}
		// selectFunction();
	}

	private void pairMatching() {
		Print.printWoowaCourseInfo();
	}
}
