package pairmatching.exception;

public class NotFoundFunctionOptionException extends IllegalArgumentException {
	public static final String ERROR_MESSAGE_FOR_NOT_FOUND_FUNCTION_OPTION = "[ERROR] 존재하지 않는 선택지입니다. :(";

	public NotFoundFunctionOptionException() {
		super(ERROR_MESSAGE_FOR_NOT_FOUND_FUNCTION_OPTION);
	}
}
