package pairmatching.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

	private static final String ASK_ORDER_MESSAGE = "기능을 선택하세요. \n1. 페어 매칭 \n2. 페어 조회 \n3. 페어 초기화 \nQ. 종료";
	private static final String ASK_MENU_MESSAGE = "\n#############################################\n"
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

	public static String getOrder() {
		System.out.println(ASK_ORDER_MESSAGE);
		return readLine();
	}

	public static String getMenu() {
		System.out.println(ASK_MENU_MESSAGE);
		return readLine();
	}

}
