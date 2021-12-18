package pairmatching.view.match;

import pairmatching.view.OutputView;

public class SearchOutputView implements OutputView {

	private static final String INTRODUCTION = "페어 매칭 결과입니다.\n";

	private String message;

	public SearchOutputView(String message) {
		this.message = message;
	}

	@Override
	public String output() {
		return INTRODUCTION + message;
	}
}
