package pairmatching.io.validator;

import pairmatching.data.ProgramData;
import pairmatching.exception.InvalidSelectException;

public class InputValidator {
	public static void isValidSelect(String select) {
		if(!ProgramData.SELECT_LIST.contains(select)) {
			throw new InvalidSelectException(ProgramData.INVALID_SELECT_ERROR);
		}
	}
}
