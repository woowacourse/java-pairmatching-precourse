package pairmatching.utils.validator;

import pairmatching.utils.Constants;

public class RematchingValidator {
	private final String input;

	public RematchingValidator(String input) {
		this.input = input;
		validate();
	}

	private void validate() {
		isRightString();
	}

	private void isRightString() {
		if (!input.equals("네") && !input.equals("아니오") ) {
			throw new IllegalArgumentException(Constants.ERROR_MISSION_PATTERN);
		}
	}
}
