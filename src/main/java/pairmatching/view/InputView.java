package pairmatching.view;

import java.util.Arrays;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.Course;

public class InputView {
	public static final String REQUEST_FOR_FUNCTION_OPTION_INPUT = "기능을 선택하세요.";
	public static final String REQUEST_MESSAGE_FOR_REQUIRED_COURSE_INFO = "과정, 레벨, 미션을 선택하세요";
	public static final String SAMPLE_MESSAGE_FOR_COURSE_INFO_INPUT = "ex) 백엔드, 레벨1, 자동차경주";
	public static final String DELIMITER_FOR_COURSE_INPUT = ", ";

	public static void printFunctionOptions() {
		System.out.println(REQUEST_FOR_FUNCTION_OPTION_INPUT);
		System.out.println("1. 페어 매칭");
		System.out.println("2. 페어 조회");
		System.out.println("3. 페어 초기화");
		System.out.println("Q. 종료");
	}

	public static void printCourseInfo() {
		System.out.println("\n#############################################");
		String courseInfo = Arrays.stream(Course.values()).map(Course::getName).collect(Collectors.joining(" | "));
		System.out.printf("과정: %s\n", courseInfo);
		System.out.println("미션:");
		System.out.println("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임");
		System.out.println("  - 레벨2: 장바구니 | 결제 | 지하철노선도");
		System.out.println("  - 레벨3:");
		System.out.println("  - 레벨4: 성능개선 | 배포");
		System.out.println("  - 레벨5:");
		System.out.println("#############################################");
	}

	public static String getCourseAndMissionInput() {
		System.out.println(REQUEST_MESSAGE_FOR_REQUIRED_COURSE_INFO);
		System.out.println(SAMPLE_MESSAGE_FOR_COURSE_INFO_INPUT);

		try {
			return validateCourseInput(Console.readLine());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return getCourseAndMissionInput();
		}
	}

	private static String validateCourseInput(String readLine) {
		// String[] courseInfoInput = readLine.split(DELIMITER_FOR_COURSE_INPUT);
		// Course.valueOf(courseInfoInput[0]);
		// return "";
		return readLine;
	}
}
