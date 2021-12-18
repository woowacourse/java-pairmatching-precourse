package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final String FUNCTION_CHOICE = "기능을 선택하세요.";
	private static final String FUNCTION_MENU = "1. 페어 매칭\n" + "2. 페어 조회\n" + "3. 페어 초기화\n" + "Q. 종료";
	private static final String PAIR_MATCHING_CHOICE = "#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: \n"
		+ "############################################\n"
		+ "과정, 레벨, 미션을 선택하세요.\n"
		+ "ex) 백엔드, 레벨1, 자동차경주";
	private static final String AGAIN_MATCH = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";

	public static String getInputCommand() {
		System.out.println(FUNCTION_CHOICE);
		System.out.println(FUNCTION_MENU);

		return Console.readLine();
	}

	public static String getInputPairMatching() {
		System.out.println(PAIR_MATCHING_CHOICE);
		return Console.readLine();
	}

	public static String getInputReMatching() {
		System.out.println(AGAIN_MATCH);
		return Console.readLine();
	}
}
