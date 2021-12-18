package pairmatching;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	private static final String SELECT_MENU_MSG = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\n4. 종료";
	private static final String COURSE_LEVEL_MISSION_MSG = "\n#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: \n"
		+ "############################################\n";
	private static final String SELECT_INPUT_COURSE_LEVEL_MISSION_MSG = "과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주";

	public static void pairmatchingInfo() {
		System.out.println(COURSE_LEVEL_MISSION_MSG);
	}

	public static String inputMenu() {
		while (true) {
			try {
				System.out.println(SELECT_MENU_MSG);
				String Menu = Console.readLine();
				Validator.notValidMenu(Menu);
				return Menu;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public static String[] inputCourseLevelMission() {
		System.out.println(COURSE_LEVEL_MISSION_MSG);
		while (true) {
			System.out.println(SELECT_INPUT_COURSE_LEVEL_MISSION_MSG);
			try {
				String[] courseLevelMission = Console.readLine().trim().replace(" ", "").split(",");
				System.out.println(Arrays.toString(courseLevelMission));
				Validator.checkinputCourseLevelMission(courseLevelMission);
				return courseLevelMission;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
