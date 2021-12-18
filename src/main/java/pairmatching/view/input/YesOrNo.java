package pairmatching.view.input;

import java.util.Arrays;

import pairmatching.exception.InputIsNotCorrectException;

public enum YesOrNo {

	YES("네", true),
	NO("아니오", false);

	private final String name;
	private final boolean value;

	YesOrNo(String name, boolean value) {
		this.name = name;
		this.value = value;
	}

	public static YesOrNo of(String name) {
		return Arrays.stream(YesOrNo.values())
			.filter(info -> name.equals(info.name))
			.findAny()
			.orElseThrow(InputIsNotCorrectException::new);
	}

	public boolean getValue() {
		return this.value;
	}

}
