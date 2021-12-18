package pairmatching.View;

import java.util.Scanner;

public class InputView {
	private static final String FUNCTION_NUMBER_GUIDE_MESSEAGE =
		"기능을 선택하세요.\n" + "1. 페어 매칭\n" + "2. 페어 조회\n" + "3. 페어 초기화\n" + "Q. 종료";
	private static final String COURSE_LEVEL_MISSION_GUIDE_MESSEAGE =
		"############################################\n"
			+ "과정: 백엔드 | 프론트엔드\n" + "미션:\n"
			+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
			+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
			+ "  - 레벨3: \n" + "  - 레벨4: 성능개선 | 배포\n"
			+ "  - 레벨5: \n"
			+ "############################################\n"
			+ "과정, 레벨, 미션을 선택하세요.\n"
			+ "ex) 백엔드, 레벨1, 자동차경주";

	private final Scanner scanner;

	public InputView(Scanner scanner) {
		this.scanner = scanner;
	}

	public int scanFunctionNumber() {
		System.out.println(FUNCTION_NUMBER_GUIDE_MESSEAGE);
		return Integer.parseInt(scanner.nextLine());
	}

	public String scanCourseAndLevelAndMission() {
		System.out.println();
		System.out.println(COURSE_LEVEL_MISSION_GUIDE_MESSEAGE);
		return scanner.nextLine();
	}
}
