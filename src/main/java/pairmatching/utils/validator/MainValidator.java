package pairmatching.utils.validator;

import pairmatching.utils.Constants;

public class MainValidator {
	private final String name;

	public MainValidator(String name) {
		this.name = name;
		validate();
	}

	private void validate() {
		isRightString();
	}

	private void isRightString() {
		if (!Constants.PATTERN.matcher(name).matches()) {
			throw new IllegalArgumentException(Constants.ERROR_MAIN_PATTERN);
		}
	}
}
