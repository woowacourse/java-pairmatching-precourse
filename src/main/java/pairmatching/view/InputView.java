package pairmatching.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

	private static String ASK_ORDER_MESSAGE = "기능을 선택하세요. \n1. 페어 매칭 \n2. 페어 조회 \n3. 페어 초기화 \nQ. 종료";

	public static String getOrder() {
		System.out.println(ASK_ORDER_MESSAGE);
		return readLine();
	}

}
