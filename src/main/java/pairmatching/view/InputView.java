package pairmatching.view;

import static pairmatching.constants.InputMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static String requestInput() {
		String input = Console.readLine();
		System.out.println();
		return input;
	}

	public static String selectFunction() {
		System.out.println(SELECT_FUNC);
		System.out.println(SELECT_FUNC_1);
		System.out.println(SELECT_FUNC_2);
		System.out.println(SELECT_FUNC_3);
		System.out.println(SELECT_FUNC_Q);
		return requestInput();
	}

	public static String selectCourse() {
		System.out.println(SELECT_COURSE);
		System.out.println(COURSE_EXAMPLE);
		return requestInput();
	}
}
