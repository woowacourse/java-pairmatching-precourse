package pairmatching.view;

import java.util.ArrayList;
import java.util.List;

import pairmatching.common.Course;
import pairmatching.common.Level;
import pairmatching.common.MainCategory;
import pairmatching.common.Mission;

public class OutputView {
	private static final String SELECT_MAIN_OPTION = "기능을 선택하세요.";
	private static final String CONNECTION = " - ";
	private static final String OUTLINE_START = "#############################################";
	private static final String OUTLINE_END = "############################################";
	private static final String ITEM_DELIMITER = " | ";
	private static final String ITEM_FORMAT = "   - ";
	private static final String SEMICOLON = ":";
	private static final String BLANK = " ";

	public void printError(String error) {
		System.out.println(error);
	}

	public void printMenus() {
		System.out.println(SELECT_MAIN_OPTION);
		for (MainCategory category : MainCategory.values()) {
			System.out.println(category.getCategory() + CONNECTION + category.getDescription());
		}
	}

	public void printCoursesAndMissions() {
		System.out.println(OUTLINE_START);
		printCourses();
		System.out.println("미션: ");
		printLevels();
		System.out.println(OUTLINE_END);
	}

	private void printCourses() {
		System.out.print("과정: ");
		List<String> courses = new ArrayList<>();
		for (Course course : Course.values()) {
			courses.add(course.getCourse());
		}
		System.out.println(String.join(ITEM_DELIMITER, courses));
	}

	private void printLevels() {
		for (Level level : Level.values()) {
			System.out.print(ITEM_FORMAT + level.getLevel() + SEMICOLON + BLANK);
			printMissions(level.getLevel());
		}

	}

	private void printMissions(String level) {
		List<String> missions = new ArrayList<>();
		for (Mission mission : Mission.values()) {
			if (level.equals(mission.getLevel())) {
				missions.add(mission.getMission());
			}
		}
		System.out.println(String.join(ITEM_DELIMITER, missions));
	}
}
