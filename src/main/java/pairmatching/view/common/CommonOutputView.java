package pairmatching.view.common;

import pairmatching.view.OutputView;

public class CommonOutputView implements OutputView {

	private final String message;

	public CommonOutputView(String message) {
		this.message = message;
	}

	@Override
	public String output() {
		return message;
	}
}
