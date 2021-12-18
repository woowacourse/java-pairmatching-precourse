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

	private void run() {
		if (input.equals("1")) {
			OutputView.printCourse();
			matchPair();
		}
		if (input.equals("2")) {
			OutputView.printCourse();
			checkPair();
		}
		if (input.equals("3")) {
			clearPair();
			OutputView.printClearMessage();
		}

	}

	private void matchPair() {
		OutputView.printEnterCurriculum();
		String[] curriculumInfo = InputView.readString().split(", ");
		Curriculum curriculum = new Curriculum(curriculumInfo[0], curriculumInfo[1], curriculumInfo[2]);
		if (pairMatching.isEmpty(curriculum)) {
			pairMatching.run(curriculum);
			return;
		}
		OutputView.printAlreadyPair();
		retry(curriculum);
	}

	private void retry(Curriculum curriculum) {
		String input = InputView.readString();
		if (input.equals("네")) {
			pairMatching.run(curriculum);
			checkPair();
		}
		if (input.equals("아니오")) {
			matchPair();
		}
		throw new IllegalArgumentException();
	}

	private void checkPair() {
		OutputView.printCourse();
		String[] curriculum = InputView.readString().split(", ");

	}

	private void clearPair() {
		pairMatching.clearMatching();
	}

	private boolean quit() {
		return input.equals("Q");
	}
}
