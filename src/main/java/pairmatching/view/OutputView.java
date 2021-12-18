package pairmatching.view;

public class OutputView {
	private static final String GUIDE = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";
	private static final String COURSE_INFORMATION = "#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n미션:\n - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ " - 레벨3:\n - 레벨4: 성능개선 | 배포\n - 레벨5:\n"
		+ "#############################################";
	private static final String ENTER_CURRICULUM = "과정, 레벨, 미션을 선택하세요.";
	private static final String DUPLICATED_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";
	private static final String PAIR_RESULT_MESSAGE = "페어 매칭 결과 입니다.";
	private static final String CLEAR_MESSAGE = "초기화 되었습니다.\n";

	public static void printGuide() {
		System.out.println(GUIDE);
	}

	public static void printCourse() {
		System.out.println(COURSE_INFORMATION);
	}

	public static void printEnterCurriculum() {
		System.out.println(ENTER_CURRICULUM);
	}

	public static void printAlreadyPair() {
		System.out.println(DUPLICATED_MESSAGE);
	}

	public static void printClearMessage() {
		System.out.println(CLEAR_MESSAGE);
	}
}
