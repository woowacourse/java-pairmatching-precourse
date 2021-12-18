package pairmatching.exception;

import pairmatching.view.output.ErrorMessage;

public class InputIsNotCorrectException extends PairMatchingException {

	public InputIsNotCorrectException() {
		super(ErrorMessage.INPUT_IS_NOT_CORRECT_MESSAGE);
	}

}
