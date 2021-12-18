package pairmatching.view.app;

import pairmatching.view.InputView;

public class ApplicationInputView implements InputView {

	private static final String PROMPT = "기능을 선택하세요.\n"
		+ "1. 페어 매칭\n"
		+ "2. 페어 조회\n"
		+ "3. 페어 초기화\n"
		+ "Q. 종료";

	@Override
	public String input() {
		return PROMPT;
	}
}
