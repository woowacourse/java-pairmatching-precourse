package pairmatching.validator;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Menu;
import pairmatching.domain.Mission;

public class MenuValidator {

	private static final String MENU_SPLIT_CRITERIA = ", ";

	public static Menu checkAndCreateMenu(String input) {
		String[] menuList = input.split(MENU_SPLIT_CRITERIA, -1);

		if (menuList.length != 3) {
			throw new IllegalArgumentException("과정, 레벨, 미션을 모두 입력해주세요.");
		}

		Course course = checkCourse(menuList[0]);
		Level level = checkLevel(menuList[1]);
		Mission mission = checkMission(level, menuList[2]);

		return new Menu(course, level, mission);
	}

	private static Course checkCourse(String courseName) {
		return Course.of(courseName);
	}

	private static Level checkLevel(String levelName) {
		return Level.of(levelName);
	}

	private static Mission checkMission(Level level, String missionName) {
		return Mission.of(level, missionName);
	}

}
