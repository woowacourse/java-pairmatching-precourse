package pairmatching.view;

public class OutputView {
	private static final String GUIDE = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료\n";
	private static final String COURSE_INFORMATION = "#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n미션:\n - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ " - 레벨3:\n - 레벨4: 성능개선 | 배포\n - 레벨 5:\n"
		+ "#############################################";

	public static void printGuide() {
		System.out.println(GUIDE);
	}

	public static void pringCourse() {
		System.out.println(COURSE_INFORMATION);
	}
}
