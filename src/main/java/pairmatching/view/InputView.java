package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String CHOICE_FUNCTION_MESSAGE = "기능을 선택하세요.\n"
		+ "1, 페어 매칭\n"
		+ "2. 페어 조회\n"
		+ "3. 페어 초기화\n"
		+ "Q. 종료";

	private static final String REQUEST_COURSE_LEVEL_MISSION_MESSAGE = "과정, 레벨, 미션을 선택하세요.\n"
		+ "ex) 백엔드, 레벨1, 자동차경주";

	public static String requestCourseLevelMission() {
		System.out.println(REQUEST_COURSE_LEVEL_MISSION_MESSAGE);
		return Console.readLine();
	}

	public static String choiceFunction() {
		System.out.println(CHOICE_FUNCTION_MESSAGE);
		return Console.readLine();
	}
}
