package pairmatching.controller;

import java.util.List;

import pairmatching.domain.Curriculum;
import pairmatching.domain.PairMatching;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	private int number = 0;
	private String input;
	private PairMatching pairMatching = new PairMatching();

	public void run() {
		do {
			OutputView.printGuide();
			input = InputView.readString();
			checkAnswer();
		} while (!quit());
	}

	private void checkAnswer() {
		if (input.equals("1")) {
			OutputView.printCourse();
			matchPair();
		}
		if (input.equals("2")) {
			OutputView.printCourse();
			String[] curriculumInfo = InputView.readString().split(", ");
			Curriculum curriculum = new Curriculum(curriculumInfo[0], curriculumInfo[1], curriculumInfo[2]);
			checkPair(curriculum);
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
		if (!pairMatching.isEmpty(curriculum)) {
			pairMatching.run(curriculum);
			System.out.println();
			checkPair(curriculum);
			return;
		}
		OutputView.printAlreadyPair();
		retry(curriculum);
	}

	private void retry(Curriculum curriculum) {
		String input = InputView.readString();
		if (input.equals("네")) {
			pairMatching.run(curriculum);
			checkPair(curriculum);
		}
		if (input.equals("아니오")) {
			matchPair();
		}
		throw new IllegalArgumentException();
	}

	private void checkPair(Curriculum curriculum) {
		OutputView.printCourse();
		List<String> matchingTeam = pairMatching.getMatching(curriculum);
		if (matchingTeam.size() % 2 == 0) {
			for (int i = 0; i < matchingTeam.size(); ) {
				System.out.println();
				System.out.print(matchingTeam.get(i) + " : " + matchingTeam.get(i + 1));
				i += 2;
			}
		}
		if (matchingTeam.size() % 2 != 0) {
			for (int i = 0; i < (matchingTeam.size() - 1); ) {
				System.out.println();
				System.out.print(matchingTeam.get(i) + " : " + matchingTeam.get(i + 1));
				i += 2;
			}
			System.out.println(" : " + matchingTeam.get(matchingTeam.size() - 1));
		}
		System.out.println();

	}

	private void clearPair() {
		pairMatching.clearMatching();
	}

	private boolean quit() {
		return input.equals("Q");
	}
}
