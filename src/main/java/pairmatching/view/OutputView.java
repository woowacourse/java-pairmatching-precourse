package pairmatching.view;

import static pairmatching.constants.HostMessages.*;
import static pairmatching.constants.ProgramConstants.*;

import pairmatching.resource.Course;
import pairmatching.resource.Level;

public class OutputView {
	private static final OutputView outputView = new OutputView();

	private OutputView() {

	}

	public static OutputView getInstance() {
		return outputView;
	}

	public void printFunctionSelectMessage() {
		System.out.println(FUNCTION_SELECT_MESSAGE);
	}

	public void printFunctionOptions() {
		System.out.printf("1. %s%n", FUNCTION1);
		System.out.printf("2. %s%n", FUNCTION2);
		System.out.printf("3. %s%n", FUNCTION3);
		System.out.printf("Q. %s%n", QUIT);
	}

	public void printAllCourseOptions() {
		System.out.println(COURSE_OPTIONS_SEPARATION_LINE);
		System.out.println(Course.getCourseOptions());
		System.out.print(Level.getLevelOptions());
		System.out.println(COURSE_OPTIONS_SEPARATION_LINE);
	}

	public void printTargetSelectMessage() {
		System.out.println(TARGET_SELECT_MESSAGE);
	}

	public void printRestMessage() {
		System.out.println(RESET_MESSAGE);
	}
}
