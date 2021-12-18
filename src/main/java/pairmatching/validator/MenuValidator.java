package pairmatching.validator;

import java.util.Arrays;
import java.util.List;

public class MenuValidator implements Validator {
	@Override
	public void exceptionInvalid(String string) {
		exceptionNotInList(Arrays.asList("1", "2", "3", "Q"), string);
	}

	protected void exceptionNotInList(List<String> menus, String string) {
		if (menus.stream().filter(validLine -> validLine.equals(string)).count() == 0) {
			throw new IllegalArgumentException("그런 메뉴는 없습니다.");
		}
	}
}
