package pairmatching.view;

import java.util.Arrays;
import java.util.stream.Collectors;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.model.Pairs;

public class OutputView {

	public static final String SELECT_MENU_INIT = "기능을 선택하세요.";
	public static final String MENU_PAIR_MATCHING = "1. 페어 매칭";
	public static final String MENU_CHECK_PAIR_RESULT = "2. 페어 조회";
	public static final String MENU_PAIR_CLEAR = "3. 페어 초기화";
	public static final String MENU_QUIT = "Q. 종료";
	public static final String BOUNDARY = "#############################################";
	public static final String COURSE_PREFIX = "과정: ";
	public static final String DELIMITER = " | ";
	public static final String MISSION_PREFIX = "미션:";
	public static final String NEW_LINE = "\n";
	public static final String TAP = "\t";
	public static final String COLON = ": ";
	public static final String PAIRING_RESULT_INIT = "페어 매칭 결과입니다.";

	public static void printMenu() {
		printMenuInit();
		printMenuCategories();
	}

	public static void printBasicInfo() {
		printBoundary();
		printCourseInfo();
		printMissionInfo();
		printBoundary();
	}

	public static void printPairResult(Pairs pairs) {
		System.out.println(PAIRING_RESULT_INIT);
		System.out.println(pairs);
	}

	private static void printMissionInfo() {
		printMissionPrefix();
		printLevelInfo();
	}

	private static void printLevelInfo() {
		StringBuilder stringBuilder = new StringBuilder();
		Arrays.stream(Level.values()).forEach(level -> stringBuilder
			.append(TAP)
			.append(getLevelPrefix(level))
			.append(getMissionNamesByLevel(level))
			.append(NEW_LINE)
		);

		System.out.println(stringBuilder);
	}

	private static String getMissionNamesByLevel(Level level) {
		return Arrays.stream(Mission.values())
			.filter(mission -> mission.isLevel(level))
			.map(Mission::getName)
			.collect(Collectors.joining(DELIMITER));
	}

	private static String getLevelPrefix(Level level) {
		return level.getName() + COLON;
	}

	private static void printMissionPrefix() {
		System.out.println(MISSION_PREFIX);
	}

	private static void printCourseInfo() {
		printCoursePrefix();
		printCourseNames();
	}

	private static void printCourseNames() {
		System.out.println(getCourseNamesString());
	}

	private static String getCourseNamesString() {
		return String.join(DELIMITER, Course.getNames());
	}

	private static void printCoursePrefix() {
		System.out.print(COURSE_PREFIX);
	}

	private static void printBoundary() {
		System.out.println(BOUNDARY);
	}

	private static void printMenuInit() {
		System.out.println(SELECT_MENU_INIT);
	}

	private static void printMenuCategories() {
		System.out.println(MENU_PAIR_MATCHING);
		System.out.println(MENU_CHECK_PAIR_RESULT);
		System.out.println(MENU_PAIR_CLEAR);
		System.out.println(MENU_QUIT);
	}
}
