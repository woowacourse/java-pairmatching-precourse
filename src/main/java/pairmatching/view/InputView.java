package pairmatching.view;

import static pairmatching.constant.message.SystemMessage.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import com.sun.org.apache.xpath.internal.compiler.FunctionTable;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.validator.InputValidator;

public class InputView {

	public static Map<String, Supplier<String>> mainChoiceMap = new LinkedHashMap<>();

	static {
		mainChoiceMap.put("1", InputView::toMatching);
		mainChoiceMap.put("2", InputView::toRetrieve);
		mainChoiceMap.put("3", InputView::toClear);
	}

	public static String chooseEntryMenu() {
		System.out.println(INPUT_ENTRY_MENU);
		String input = Console.readLine();
		InputValidator.validateEntryMenu(input);
		String courseInput = mainChoiceMap.get(input).get();
		return courseInput;
	}

	private static String toMatching() {
		System.out.println(INPUT_COURSE_MENU);
		String input = Console.readLine();
		InputValidator.validateCourseMenu(input);
		return input;
	}

	private static String toRetrieve() {
		return null;
	}

	private static String toClear() {
		return null;
	}
}
