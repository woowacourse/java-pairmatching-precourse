package pairmatching.view;

import pairmatching.utils.ErrorMessageConstants;

public class PairMatchingOutputView {
	private static final String FUNCTION_INPUT = "기능을 선택하세요.";
	private static final String PAIR_MATCHING_FUNCTION = "1. 페어 매칭";
	private static final String PAIR_FINDING_FUNCTION = "2. 페어 조회";
	private static final String PAIR_INITIALIZING_FUNCTION = "3. 페어 초기화";
	private static final String QUIT_FUNCTION = "Q. 종료";
	private static final String COURSE_LEVEL_MISSION_INPUT = "과정, 레벨, 미션을 선택하세요.";
	private static final String COURSE_LEVEL_MISSION_INPUT_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
	private static final String COURSE = "과정";
	private static final String BACKEND = "백엔드";
	private static final String FRONTEND = "프론트엔드";
	private static final String MISSION = "미션";
	private static final String LEVEL_ONE = "- 레벨1: 자동차경주 | 로또 | 숫자야구게임";
	private static final String LEVEL_TWO = "- 레벨2: 장바구니 | 결제 | 지하철노선도";
	private static final String LEVEL_THREE = "- 레벨3: ";
	private static final String LEVEL_FOUR = "- 레벨4: 성능개선 | 배포";
	private static final String LEVEL_FIVE = "- 레벨5: ";
	private static final String LINE_HASH = "#############################################";
	private static final String MATCHING_RESULT_OUTPUT = "페어 매칭 결과입니다.";
	private static final String DELIMITER = " | ";
	private static final String COLON = ":";
	private static final String WHITESPACE = " ";
	private static final String LINE_WRAPPING = "\n";

	private PairMatchingOutputView() {
	}

	public static void printFunctionInputMessage() {
		StringBuilder functionInputMessage = new StringBuilder();
		functionInputMessage.append(FUNCTION_INPUT)
			.append(LINE_WRAPPING)
			.append(PAIR_MATCHING_FUNCTION)
			.append(LINE_WRAPPING)
			.append(PAIR_FINDING_FUNCTION)
			.append(LINE_WRAPPING)
			.append(PAIR_INITIALIZING_FUNCTION)
			.append(LINE_WRAPPING)
			.append(QUIT_FUNCTION);
		System.out.println(functionInputMessage.toString());
	}

	public static void printCourseAndMissionInputMessage() {
		printCourseAndMission();
		System.out.println(COURSE_LEVEL_MISSION_INPUT);
		System.out.println(COURSE_LEVEL_MISSION_INPUT_EXAMPLE);
	}
	public static void printCourseAndMission() {
		StringBuilder courseAndMissionMessage = new StringBuilder();
		courseAndMissionMessage.append(LINE_WRAPPING)
			.append(LINE_HASH)
			.append(LINE_WRAPPING)
			.append(printCourses())
			.append(LINE_WRAPPING)
			.append(printMissions())
			.append(LINE_HASH);
		System.out.println(courseAndMissionMessage.toString());
	}

	private static String printCourses() {
		StringBuilder course = new StringBuilder();
		return course.append(COURSE)
			.append(COLON)
			.append(WHITESPACE)
			.append(BACKEND)
			.append(DELIMITER)
			.append(FRONTEND)
			.toString();
	}

	private static String printMissions() {
		StringBuilder mission = new StringBuilder();
		return mission.append(MISSION)
			.append(COLON)
			.append(LINE_WRAPPING)
			.append(LEVEL_ONE + LINE_WRAPPING)
			.append(LEVEL_TWO + LINE_WRAPPING)
			.append(LEVEL_THREE + LINE_WRAPPING)
			.append(LEVEL_FOUR + LINE_WRAPPING)
			.append(LEVEL_FIVE + LINE_WRAPPING)
			.toString();
	}

	public static void printMatchingResult(String matchingResult) {
		System.out.println(LINE_WRAPPING);
		System.out.println(MATCHING_RESULT_OUTPUT);
		System.out.println(matchingResult);
	}

	public static void printErrorMessage(String errorMessage) {
		System.out.println(ErrorMessageConstants.ERROR + errorMessage);
	}
}
