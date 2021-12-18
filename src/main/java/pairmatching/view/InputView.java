package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static final String INFO_FUNCTION = "기능을 선택하세요.";
	public static final String FUNCTION_PAIR_MATCHING = "1. 페어 매칭";
	public static final String FUNCTION_PAIR_LOOKUP = "2. 페어 조회";
	public static final String FUNCTION_PAIR_INITIALIZATION = "3. 페어 초기화";
	public static final String FUNCTION_EXIT = "Q. 종료";
	public static final String INFO_PAIR_MATCHING = "과정, 레벨, 미션을 선택하세요.\n"
		+ "ex) 백엔드, 레벨1, 자동차경주";

	public static String getFunction() {
		System.out.println(INFO_FUNCTION);
		System.out.println(FUNCTION_PAIR_MATCHING);
		System.out.println(FUNCTION_PAIR_LOOKUP);
		System.out.println(FUNCTION_PAIR_INITIALIZATION);
		System.out.println(FUNCTION_EXIT);
		return Console.readLine();
	}

	public static String getPairMathing() {
		System.out.println(INFO_PAIR_MATCHING);
		return Console.readLine();
	}
}
