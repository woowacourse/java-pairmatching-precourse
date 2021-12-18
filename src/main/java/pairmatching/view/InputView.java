package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String FUNCTION_CHOICE = "기능을 선택하세요.";
	private static final String FUNCTION_MENU = "1. 페어 매칭\n" + "2. 페어 조회\n" + "3. 페어 초기화\n" + "Q. 종료";

	public static String getInputCommand() {
		System.out.println(FUNCTION_CHOICE);
		System.out.println(FUNCTION_MENU);

		return Console.readLine();
	}
}
