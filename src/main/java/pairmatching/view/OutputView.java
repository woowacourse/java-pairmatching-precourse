package pairmatching.view;

import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class OutputView {
	private static final String HASH_SEPARATOR = "#############################################";
	private static final String COURSE_LIST_FORM = "과정: %s";
	private static final String LEVEL_LIST_MESSAGE = "미션:";
	private static final String LEVEL_LIST_FORM = "  - %s: %s";

	public static void outputCourseAndLevel() {
		System.out.println(HASH_SEPARATOR);
		System.out.println(String.format(COURSE_LIST_FORM, Course.getNamesJoinBar()));
		System.out.println(LEVEL_LIST_MESSAGE);
		for (Level level : Level.values()) {
			System.out.println(String.format(LEVEL_LIST_FORM, level.getName(), level.getMissionsJoinBar()));
		}
		System.out.println(HASH_SEPARATOR);
	}
}
