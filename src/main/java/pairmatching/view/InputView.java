package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static String inputMainMenu() {
		return Console.readLine();
	}

	public static String inputRollLevelAndMission() {
		System.out.println("과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주");
		return Console.readLine();
	}
}
