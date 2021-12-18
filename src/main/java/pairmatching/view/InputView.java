package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String SPLIT_LINE = "#############################################";
	private static final String MISSION_LIST = "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: ";
	private static final String MISSION_INPUT_MESSAGE = "과정, 레벨, 미션을 선택하세요.";
	private static final String MISSION_INPUT_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";

	public static String inputString() {
		return Console.readLine().trim();
	}

	public static String selectFunction() {
		System.out.println("1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료");
		return inputString();
	}

	public static String inputMission() {
		System.out.println();
		System.out.println(MISSION_LIST);
		System.out.println(MISSION_INPUT_MESSAGE);
		System.out.println(MISSION_INPUT_EXAMPLE);
		return inputString();
	}
}
