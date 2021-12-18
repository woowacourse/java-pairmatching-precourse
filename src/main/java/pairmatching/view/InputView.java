package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public static String inputMainMenu() {
		OutputView.printMainMenu();
		return Console.readLine();
	}

	public static String inputCourseLevelMission() {
		OutputView.printInputCourseLevelMission();
		return Console.readLine();
	}
}