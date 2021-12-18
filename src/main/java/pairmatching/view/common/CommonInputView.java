package pairmatching.view.common;

import pairmatching.view.InputView;

public class CommonInputView implements InputView {

	private final String prompt;

	public CommonInputView(String prompt) {
		this.prompt = prompt;
	}

	@Override
	public String input() {
		return prompt;
	}
}
