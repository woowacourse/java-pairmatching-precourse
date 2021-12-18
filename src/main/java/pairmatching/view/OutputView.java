package pairmatching.view;

import java.util.stream.Stream;

import pairmatching.Function;
import pairmatching.domain.Course;
import pairmatching.domain.Level;

public class OutputView {
	private static final String MAIN_TITLE = "기능을 선택하세요.";
	private static final String QUESTION_MISSION = "과정, 레벨, 미션을 선택하세요.";
	private static final String QUESTION_MISSION_EX = "ex) 백엔드, 레벨1, 자동차경주";

	private static final String PREFIX_COURSE = "과정: ";
	private static final String PREFIX_MISSION = "미션: ";
	private static final String CONJUNCTION = " | ";

	private static final String OPTION_FORMAT = "%s. %s%n";
	private static final String LEVEL_FORMAT = "  - %s: %s%n";
	private static final String ERROR_FORMAT = "[ERROR] %s%n";

	private static final String BORDER = "############################################";

	public void printMain() {
		printBlankLine();
		System.out.println(MAIN_TITLE);
		Stream.of(Function.values())
			.forEach(
				function -> System.out.printf(OPTION_FORMAT, function.getCode(), function.getName()));
	}

	public void printCourseAndMission() {
		printBlankLine();
		printBorderLine();
		printCourse();
		printMission();
		printBorderLine();
		System.out.println(QUESTION_MISSION);
		System.out.println(QUESTION_MISSION_EX);
	}

	public void printError(Exception exception) {
		printBlankLine();
		System.out.printf(ERROR_FORMAT, exception.getMessage());
	}

	private void printCourse() {
		StringBuilder courses = new StringBuilder();
		courses.append(PREFIX_COURSE);
		Stream.of(Course.values()).forEach(
			course -> courses.append(course.getName()).append(CONJUNCTION)
		);
		courses.delete(
			courses.lastIndexOf(CONJUNCTION), courses.length());
		System.out.println(courses);
	}

	private void printMission() {
		System.out.println(PREFIX_MISSION);
		Stream.of(Level.values()).forEach(level -> printLevel(level));
	}

	private void printLevel(Level level) {
		StringBuilder missions = new StringBuilder();
		if (level.getMissions().size() == 0) {
			System.out.printf(LEVEL_FORMAT, level.getName(), "");
			return;
		}
		level.getMissions().stream().forEach(
			mission -> missions.append(mission).append(CONJUNCTION)
		);
		missions.delete(
			missions.lastIndexOf(CONJUNCTION), missions.length());
		System.out.printf(LEVEL_FORMAT, level.getName(), missions);
	}

	private void printBlankLine() {
		System.out.println();
	}

	private void printBorderLine() {
		System.out.println(BORDER);
	}
}
