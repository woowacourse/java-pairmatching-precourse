package pairmatching.validator;

import java.util.Arrays;

public class YesOrNoValidator extends MenuValidator {
	@Override
	public void exceptionInvalid(String string) {
		exceptionNotInList(Arrays.asList("네", "아니오"), string);
	}
}
