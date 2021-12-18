package pairmatching.view;

import java.util.List;

import pairmatching.domain.pair.Pairs;

public class OutputView {
	private static final String ERROR_FORMAT = "[ERROR] %s";
	private static final String VERTICAL_BAR_DELIMITER = " | ";

	private static final String IO_ERROR = "파일을 읽어오는데 문제가 발생했습니다.";

	private static final String MAIN_MENU = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";
	private static final String INPUT_COURSE_LEVEL_MISSION = "과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주";
	private static final String PAIR_MATCHING_RESULT = "페어 매칭 결과입니다.";

	private static final String CLEAR = "초기화 되었습니다.";

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

	public static void printPairMatching(Pairs pairs) {
		System.out.println(PAIR_MATCHING_RESULT);
		System.out.println(pairs);
	}

	public static void printClear() {
		System.out.println(CLEAR);
	}

	public static void printRematch() {
		System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오");
	}

	public static void printCantMatch() {
		System.out.println(String.format(ERROR_FORMAT, "페어를 매칭할 수 없습니다."));
	}
}
