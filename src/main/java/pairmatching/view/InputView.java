package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.validator.InputValidator;

public class InputView {
	private static final String MAIN_MENU = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";
	private static final String CHOICE_COURSE_LEVEL_MISSION = "과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주";
	private static final String REMATCHING_YES_OR_NO = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";

	public static String printMainMenu() {
		try {
			System.out.println(MAIN_MENU);
			String input = Console.readLine();
			InputValidator.checkInputValidation(input);
			return input;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return printMainMenu();
		}
	}

	public static String inputCourseAndLevelAndMission() {
		System.out.println(CHOICE_COURSE_LEVEL_MISSION);
		return Console.readLine();
	}

	public static String askRematching() {
		System.out.println(REMATCHING_YES_OR_NO);
		String input = Console.readLine();

		return input;
	}
}
