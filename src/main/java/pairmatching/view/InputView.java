package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.Menu;

public class InputView {
	private static final String INPUT_FUNCTION_MESSAGE = "기능을 선택하세요.\n";
	private static final String LINE = "#############################################\n";
	private static final String COURSE_NAME = "과정";
	private static final String MISSION_NAME = "미션";
	private static final String DASH = " - ";
	private static final String INPUT_MATCHING_INFO_MESSAGE = "과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주";
	private static final String COLON = ": ";
	private static final String PIPE = " | ";
	private static final String END_LINE = "\n";

	public String getInputFunction() {
		printInputFunction();
		return Console.readLine();
	}

	private void printInputFunction() {
		StringBuilder message = new StringBuilder(INPUT_FUNCTION_MESSAGE);
		for (Menu function : Menu.values()) {
			message.append(function.getFunctionNumber())
				.append(". ")
				.append(function.getFunctionName())
				.append("\n");
		}
		System.out.print(message);
	}

	public String getInputMatching() {
		printInputMatching();
		return Console.readLine();
	}

	private void printInputMatching() {
		StringBuilder message = new StringBuilder("\n");
		message.append(LINE);
		addCourse(message);
		addMission(message);
		message.append(LINE).append(INPUT_MATCHING_INFO_MESSAGE);
		System.out.println(message);
	}

	private void addCourse(StringBuilder message) {
		message.append(COURSE_NAME).append(COLON);
		for (Course course : Course.values()) {
			message.append(String.join(PIPE, course.getName()));
		}
		message.append(END_LINE);
	}

	private void addMission(StringBuilder message) {
		message.append(MISSION_NAME).append(COLON).append(END_LINE);

		for (Level level : Level.values()) {
			message.append(DASH).append(level.getName()).append(COLON);
			message.append(String.join(PIPE, level.getMissions()));
			message.append(END_LINE);
		}
	}
}
