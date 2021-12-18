package pairmatching.controller;

import pairmatching.domain.Curriculum;
import pairmatching.domain.PairMatching;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	private int number = 0;
	private String input;
	private PairMatching pairMatching = new PairMatching();

	public PairMatchingController() {
		do {
			OutputView.printGuide();
			input = InputView.readString();
		} while (!quit());
	}

	private void matchPair() {
		OutputView.printCourse();
		String[] curriculumInfo = InputView.readString().split(", ");
		Curriculum curriculum = new Curriculum(curriculumInfo[0], curriculumInfo[1], curriculumInfo[2]);
		if (pairMatching.isEmpty(curriculum)) {

		}

	}

	private void checkPair() {
		OutputView.printCourse();
		String[] curriculum = InputView.readString().split(", ");

	}

	private void cleanPair() {

	}

	private boolean quit() {
		return input.equals("Q");
	}
}
