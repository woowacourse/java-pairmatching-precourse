package pairmatching.exception;

import pairmatching.view.output.ErrorMessage;

public class FunctionChoiceNotFoundException extends PairMatchingException {

	public FunctionChoiceNotFoundException() {
		super(ErrorMessage.FUNCTION_CHOICE_NOT_FOUND_MESSAGE);
	}

}
