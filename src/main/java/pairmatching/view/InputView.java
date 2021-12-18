package pairmatching.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

	static final String REQUEST_FUNCTION_MSG = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";
	static final String REQUEST_PAIR_RESOURCE_MSG = "\n#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: \n"
		+ "############################################\n"
		+ "과정, 레벨, 미션을 선택하세요.";

	public String requestFunction() {
		System.out.println(REQUEST_FUNCTION_MSG);
		return readLine();
	}

	public String requestSource() {
		System.out.println(REQUEST_PAIR_RESOURCE_MSG);
		return readLine();
	}
}
