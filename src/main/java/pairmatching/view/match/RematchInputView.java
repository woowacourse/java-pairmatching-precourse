package pairmatching.view.match;

import pairmatching.view.InputView;

public class RematchInputView implements InputView {

	private static final String PROMPT = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
		+ "네 | 아니오";

	@Override
	public String input() {
		return PROMPT;
	}
}
