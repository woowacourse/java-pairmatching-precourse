package pairmatching.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

	private static final String ASK_ORDER_MESSAGE = "기능을 선택하세요. \n1. 페어 매칭 \n2. 페어 조회 \n3. 페어 초기화 \nQ. 종료";
	private static final String ASK_MENU_MESSAGE = "과정, 레벨, 미션을 선택하세요.\n"
		+ "ex) 백엔드, 레벨1, 자동차경주";
	private static final String ASK_RE_MATCHING_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
		+ "네 | 아니오";

	public static String getOrder() {
		System.out.println(ASK_ORDER_MESSAGE);
		String input = readLine();
		System.out.println();
		return input;
	}

	public static String getMenu() {
		System.out.println(ASK_MENU_MESSAGE);
		String input = readLine();
		System.out.println();
		return input;
	}

	public static String getReMatching() {
		System.out.println(ASK_RE_MATCHING_MESSAGE);
		String input = readLine();
		System.out.println();
		return input;
	}

}
