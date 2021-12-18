package pairmatching.view;

import java.util.List;

public class OutputView {
	private static final String NEW_LINE = "\n";
	private static final String ERROR_MSG_PREFIX = "[ERROR] ";

	private static final String MAIN_OPTION_MATCHING = "1. 페어 매칭";
	private static final String MAIN_OPTION_GET_INFO = "2. 페어 조회";
	private static final String MAIN_OPTION_INIT = "3. 페어 초기화";
	private static final String MAIN_OPTION_QUIT = "Q. 종료";

	private static final String DELIMIT_LINE = "#############################################";
	private static final String COURSE_MSG = "과정: ";
	private static final String MISSION_MSG = "미션: ";

	private static final String MATCHING_RESULT_MSG = "페어 매칭 결과입니다.";
	private static final String MATCHING_INIT_MSG = "초기화 되었습니다.";

	public static void displayMainView() {
		String mainViewMsg = MAIN_OPTION_MATCHING + NEW_LINE
			+ MAIN_OPTION_GET_INFO + NEW_LINE
			+ MAIN_OPTION_INIT + NEW_LINE
			+ MAIN_OPTION_QUIT + NEW_LINE;
		System.out.print(mainViewMsg);
	}

	public static void displayErrorMsg(String errorMsg) {
		System.out.println(NEW_LINE + ERROR_MSG_PREFIX + errorMsg + NEW_LINE);
	}

	public static void displayInfo(List<String> course, List<String> mission) {
		String resultMsg = NEW_LINE + DELIMIT_LINE + NEW_LINE
			+ COURSE_MSG + getCourseInfo(course) + NEW_LINE
			+ MISSION_MSG + NEW_LINE + getMissionInfo(mission)
			+ DELIMIT_LINE;
		System.out.print(resultMsg);
	}

	private static StringBuilder getCourseInfo(List<String> course) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < course.size() - 1; i++) {
			stringBuilder.append(course.get(i)).append(" | ");
		}
		return stringBuilder.append(course.get(course.size() - 1));
	}

	private static StringBuilder getMissionInfo(List<String> mission) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < mission.size(); i++) {
			stringBuilder.append("레벨").append(i + 1).append(": ")
				.append(mission.get(i)).append(NEW_LINE);
		}
		return stringBuilder;
	}

	public static void displayMatchingResult(List<String> result) {
		System.out.println(NEW_LINE + MATCHING_RESULT_MSG);
		for (String pair : result) {
			System.out.println(pair);
		}
		System.out.println();
	}

	public static void displayInitMsg() {
		System.out.println(NEW_LINE + MATCHING_INIT_MSG + NEW_LINE);
	}
}
