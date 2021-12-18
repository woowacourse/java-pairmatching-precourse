package pairmatching.view.common;

import pairmatching.view.ErrorView;

public class CommonErrorView implements ErrorView {

	private static final String PREFIX = "[ERROR] ";

	private final String message;

	public CommonErrorView(String message) {
		this.message = message;
	}

	@Override
	public String error() {
		return PREFIX + message;
	}
}
