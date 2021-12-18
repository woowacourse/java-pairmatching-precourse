package pairmatching.view;

import pairmatching.constants.Messages;
import pairmatching.model.Levels;
import pairmatching.model.MatchingInfo;

public class OutputView {

	public void printChooseFeature() {
		System.out.println(Messages.CHOOSE_MESSAGES);
	}

	public void printCourseAndMissionInfo(Levels levels) {
		System.out.println(Messages.LINE_DELIMITER);
		System.out.println(levels.toStringLevels());
		System.out.println(Messages.LINE_DELIMITER);
		System.out.println(Messages.INPUT_CHOOSE_MESSAGES);
	}

	public void printNewLine() {
		System.out.println();
	}

	public void printPairMatchingResult(MatchingInfo matchingInfo) {
		System.out.println("페어 매칭 결과 입니다.");
		matchingInfo.getPairList().stream()
			.forEach(pair -> System.out.println(pair.toString()));
	}
}
