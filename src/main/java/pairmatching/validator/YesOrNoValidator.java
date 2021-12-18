package pairmatching.validator;

import static pairmatching.Constants.*;

import java.util.Arrays;

public class YesOrNoValidator extends MenuValidator {
	@Override
	public void exceptionInvalid(String string) {
		exceptionNotInList(Arrays.asList(YES, NO), string);
	}
}
