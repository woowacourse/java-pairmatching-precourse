package pairmatching;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String OPERATIONS_TO_CHOOSE = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";

	public static void printChooseOperation() {
		System.out.println(OPERATIONS_TO_CHOOSE);
	}
	public static String getInputToOperate() {
		return Console.readLine();
	}
}
