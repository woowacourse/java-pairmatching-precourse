package pairmatching.view;

import java.util.List;

public class OutputView {
	private static final String ERROR_FORMAT = "[ERROR] %s";
	private static final String VERTICAL_BAR_DELIMITER = " | ";

	private static final String IO_ERROR = "파일을 읽어오는데 문제가 발생했습니다.";

	private static final String MAIN_MENU = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";
	private static final String INPUT_COURSE_LEVEL_MISSION = "과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주";

	public static void printError(Exception e) {
		System.out.println(String.format(ERROR_FORMAT, e.getMessage()));
	}

	public static void printIoError() {
		System.out.println(String.format(ERROR_FORMAT, IO_ERROR));
	}

	public static void printMainMenu() {
		System.out.println(MAIN_MENU);
	}

	// 과정, 레벨, 미션 정보를 출력
	public static void printOverview(List<String> courses, List<String> levelMissions) {
		// TODO: 가능하면 상수로 분리
		System.out.println("#############################################");
		System.out.println("과정: " + String.join(VERTICAL_BAR_DELIMITER, courses));
		System.out.println("미션: ");

		for (String levelMission : levelMissions) {
			System.out.println("  - " + levelMission);
		}
		System.out.println("#############################################");
	}

	public static void printInputCourseLevelMission() {
		System.out.println(INPUT_COURSE_LEVEL_MISSION);
	}
}
