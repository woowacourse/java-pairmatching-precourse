package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String REQUEST_COURSE_LEVEL_MISSION_MESSAGE = "과정, 레벨, 미션을 선택하세요.\n"
		+ "ex) 백엔드, 레벨1, 자동차경주";

	public static String requestCourseLevelMission() {
		System.out.println(REQUEST_COURSE_LEVEL_MISSION_MESSAGE);
		return Console.readLine();
	}
}
