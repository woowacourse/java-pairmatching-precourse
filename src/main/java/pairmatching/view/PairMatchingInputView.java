package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class PairMatchingInputView {
	private PairMatchingInputView() {
	}

	public static String readFunction() {
		PairMatchingOutputView.printFunctionInputMessage();
		return Console.readLine();
	}

	public static String readCourseAndMission() {
		PairMatchingOutputView.printCourseAndMissionInputMessage();
		return Console.readLine();
	}
}
