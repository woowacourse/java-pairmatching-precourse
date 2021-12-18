package pairmatching.view;

import static pairmatching.constant.message.SystemMessage.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import com.sun.org.apache.xpath.internal.compiler.FunctionTable;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatch;
import pairmatching.repository.PairMatchRepository;
import pairmatching.validator.InputValidator;

public class InputView {

	public static String chooseEntryMenu() {
		System.out.println(INPUT_ENTRY_MENU);
		String input = Console.readLine();
		InputValidator.validateEntryMenu(input);
		if (input.equals(QUIT)) {
			return QUIT;
		}
		return input;
	}

	public static String inputMatching() {
		return commonSubMenuInput();
	}

	public static String inputRetrieve() {
		return commonSubMenuInput();
	}

	public static String commonSubMenuInput() {
		System.out.println(INPUT_COURSE_MENU);
		return Console.readLine();
	}
}
