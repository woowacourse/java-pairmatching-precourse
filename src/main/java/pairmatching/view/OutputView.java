package pairmatching.view;

import pairmatching.constants.Messages;
import pairmatching.model.Levels;

public class OutputView {

	public void printChooseFeature() {
		System.out.println(Messages.CHOOSE_MESSAGES);
	}

	public void printCourseAndMissionInfo(Levels levels) {
		System.out.println(Messages.LINE_DELIMITER);
		System.out.println(levels.toStringLevels());
		System.out.println(Messages.LINE_DELIMITER);
	}

	public void printNewLine() {
		System.out.println();
	}

}
