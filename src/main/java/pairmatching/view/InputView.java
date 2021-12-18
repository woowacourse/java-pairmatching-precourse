package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String CHOOSE_FUNCTION = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";

	public static String chooseFunction() {
		System.out.println(CHOOSE_FUNCTION);
		return Console.readLine();
	}
}
