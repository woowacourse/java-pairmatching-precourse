package pairmatching.exception;

public class FunctionInputFormatException extends CustomException{

	static final String FUNCTION_INPUT_EXCEPTION_MSG = "[ERROR] 1,2,3 또는 Q를 입력해야 합니다.";
	public FunctionInputFormatException() {
		getMessage(FUNCTION_INPUT_EXCEPTION_MSG);
	}

	@Override
	public void getMessage(String message) {
		System.out.println(message);
	}
}
