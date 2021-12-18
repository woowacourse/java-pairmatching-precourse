package pairmatching.view.clear;

import pairmatching.view.OutputView;

public class ClearOutputView implements OutputView {
	private static final String MESSAGE = "초기화 되었습니다.";

	@Override
	public String output() {
		return MESSAGE;
	}
}
