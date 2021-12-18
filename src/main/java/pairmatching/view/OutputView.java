package pairmatching.view;

import java.util.Arrays;

import pairmatching.domain.Course;
import pairmatching.domain.Function;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class OutputView {

	private static final String FUNCTION_SELECT_MESSAGE = "기능을 선택하세요.";
	private static final String COURSE_LEVEL_MISSION_SELECT_MESSAGE = "과정, 레벨, 미션을 선택하세요.";

	private static final String DIVIDING_LINE = "\n################################";
	private static final String COURSE = "과정";
	private static final String MISSION = "미션";

	private static final String REMATCH_OR_EXIT = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";

	private static String courseMessage;
	private static String missionMessage;

	public void printFunctionList() {
		System.out.println(FUNCTION_SELECT_MESSAGE);
		Arrays.stream(Function.values())
			.forEach(function -> System.out.println(function.getMessage()));
	}

	public void printCourseAndLevelAndMission() {
		System.out.println(DIVIDING_LINE);

		printCourses();
		printMissionOfLevels();

		System.out.println(DIVIDING_LINE);
		System.out.println(COURSE_LEVEL_MISSION_SELECT_MESSAGE);
	}

	private void printMissionOfLevels() {
		System.out.println(MISSION + ": ");
		Arrays.stream(Level.values())
				.forEach(level -> printMissionOfLevel(level));
	}

	private void printMissionOfLevel(Level level) {
		missionMessage = "";

		System.out.print("-" + level.getName() + ": ");
		Mission.getByLevel(level)
			.stream()
			.forEach(mission -> missionMessage += " | " + mission.getName());

		System.out.println(missionMessage.replaceFirst(" \\| ", ""));
	}

	private void printCourses() {
		courseMessage = "";

		System.out.print(COURSE + ": ");
		Arrays.stream(Course.values())
				.forEach(course -> courseMessage += " | " +  course.getName());

		System.out.print(courseMessage.replaceFirst(" \\| ", "") + "\n");
	}

	public void printRematchOrExit() {
		System.out.println(REMATCH_OR_EXIT);
	}
}
