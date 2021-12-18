package pairmatching.view;

import java.util.Arrays;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Role;

public class OutputView {
	private static final String CHOOSE_ROLE = "기능을 선택하세요.";
	private static final String COURSE = "과정: ";
	private static final String MISSION = "미션: ";
	private static final String DIVIDING_LINE = "#############################################";
	private static final String SELECT_COURSE_LEVEL_MISSION = "과정, 레벨, 미션을 선택하세요";

	public void printRoleList() {
		System.out.println(CHOOSE_ROLE);
		Arrays.stream(Role.values())
			.forEach(role -> System.out.println(role.toString()));
	}

	public void printCourseAndMission() {
		printDividingLine();
		printCourse();
		printMission();
		printDividingLine();
	}

	private void printCourse() {
		System.out.print(COURSE);
		System.out.println(Course.getAllCourse());
	}

	private void printMission() {
		System.out.println(MISSION);
		System.out.println(Level.getAllLevel());
	}

	private void printDividingLine() {
		System.out.println(DIVIDING_LINE);
	}

	public void printCourseLevelMission() {
		System.out.println(SELECT_COURSE_LEVEL_MISSION);
	}
}
