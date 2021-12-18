package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.Menu;
import pairmatching.constant.Mission;
import pairmatching.domain.PairMatching;

public class InputView {
	private final static String INPUT_FUNCTION_MESSAGE = "기능을 선택하세요.\n";
	private final static String LINE = "#############################################\n";
	private final static String COURSE_NAME = "과정";
	private final static String MISSION_NAME = "미션";
	private final static String DASH = " - ";
	private final static String INPUT_MATCHING_INFO_MESSAGE = "과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주";
	private final static String COLON = ": ";
	private final static String PIPE = " | ";
	private final static String END_LINE = "\n";

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
		message.append(COURSE_NAME)
			.append(COLON);
		for (Course course : Course.values()) {
			if (course.ordinal() != 0) {
				message.append(PIPE);
			}
			message.append(course.getName());
		}
		message.append(END_LINE);
	}

	private void addMission(StringBuilder message) {
		message.append(MISSION_NAME).append(COLON).append(END_LINE);

		for (Level level : Level.values()) {
			message.append(DASH).append(level.getName()).append(COLON);
			for (String mission : level.getMissions()) {
				message.append(mission).append(PIPE);
			}
			message.append(END_LINE);
		}
	}
}
