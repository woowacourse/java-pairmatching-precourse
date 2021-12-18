package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Course;
import pairmatching.domain.Function;
import pairmatching.domain.Level;

public class Input {
	private static final String FUNCTION_SELECT_TEXT = "기능을 선택하세요.";
	private static final String BORDER_LINE_TEXT = "#############################################";
	private static final String COURSE_TEXT = "과정: ";
	private static final String MISSION_TEXT = "미션: ";
	private static final String NEW_LINE = "\n";

	public static Function requestToSelectFunction() {
		printFunctions();
		return readFunctionSelect();
	}

	private static void printFunctions() {
		System.out.println(FUNCTION_SELECT_TEXT);
		Function.getFunctionList().forEach(System.out::println);
	}

	private static Function readFunctionSelect() {
		try {
			String input = Console.readLine();
			InputValidator.validateAllowedFunction(input);
			return Function.byKey(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readFunctionSelect();
		}
	}

	public static void requestToSelectMission() {
		System.out.println(buildMissionList());
	}

	private static String buildMissionList() {
		String result = "";
		result = appendCourse(result);
		result = appendMission(result);
		result = enclosedWithBorder(result);
		return result;
	}

	private static String appendCourse(String str) {
		return str + COURSE_TEXT + Course.listAsString() + NEW_LINE;
	}

	private static String appendMission(String str) {
		return str + MISSION_TEXT + NEW_LINE + Level.listAsString();
	}

	private static String enclosedWithBorder(String str) {
		return BORDER_LINE_TEXT + NEW_LINE + str + NEW_LINE + BORDER_LINE_TEXT + NEW_LINE;
	}
}
