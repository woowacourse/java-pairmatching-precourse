package pairmatching.view;

public class OutputView {
	public static final String INPUT_FUNCTION_ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.";
	public static final String INPUT_COURSE_LEVEL_MISSION_ERROR_MESSAGE = "[ERROR] 잘못된 코스, 미션 입니다. 다시 입력해 주세요.";

	public static void printInputFunctionError() {
		System.out.println(INPUT_FUNCTION_ERROR_MESSAGE);
	}

	public static void printInputCourseLevelMissionError() {
		System.out.println(INPUT_COURSE_LEVEL_MISSION_ERROR_MESSAGE);
	}
}
