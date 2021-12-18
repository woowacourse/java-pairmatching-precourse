package pairmatching.view.common;

import pairmatching.view.ErrorView;

public class CommonErrorView implements ErrorView {

	private final String message;

	public CommonErrorView(String message) {
		this.message = message;
	}

	@Override
	public String error() {
		return message;
	}
}
