package pairmatching;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String OPERATIONS_TO_CHOOSE = "\n기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";
	private static final String COURSE_AND_MISSION = "\n#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: \n"
		+ "############################################";
	private static final String INPUT_MATCHING_STATUS = "과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주";
	private static final String ASK_REMATCHING = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";

	public static void printChooseOperation() {
		System.out.println(OPERATIONS_TO_CHOOSE);
	}
	public static String getInputToOperate() {
		return Console.readLine();
	}

	public static void printCourseAndMission() {
		System.out.println(COURSE_AND_MISSION);
	}

	public static String getInputToMatch() {
		System.out.println(INPUT_MATCHING_STATUS);
		return Console.readLine();
	}

	public static String getReMatching() {
		System.out.println(ASK_REMATCHING);
		return getRematchingResponse();
	}

	private static String getRematchingResponse() {
		return Console.readLine();
	}
}
