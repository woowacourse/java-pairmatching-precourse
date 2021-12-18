package pairmatching.validator;

import static pairmatching.Constants.*;

import java.util.Arrays;
import java.util.List;

public class MenuValidator implements Validator {
	@Override
	public void exceptionInvalid(String string) {
		exceptionNotInList(Arrays.asList(MAKE_PAIR, SEARCH_PAIR, CLEAR_PAIR, QUIT), string);
	}

	protected void exceptionNotInList(List<String> menus, String string) {
		if (menus.stream().filter(validLine -> validLine.equals(string)).count() == 0) {
			throw new IllegalArgumentException(NO_MENU);
		}
	}
}
