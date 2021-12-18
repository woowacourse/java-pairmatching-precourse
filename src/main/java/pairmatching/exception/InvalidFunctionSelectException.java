package pairmatching.exception;

import static pairmatching.constant.ExceptionMessages.*;

public class InvalidFunctionSelectException extends IllegalArgumentException {
	public InvalidFunctionSelectException () {
		super(INVALID_FUNCTION_SELECT_EXCEPTION);
		System.out.println(INVALID_FUNCTION_SELECT_EXCEPTION);
	}

}
