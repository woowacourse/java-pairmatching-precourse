package pairmatching.view;

import pairmatching.view.console.ConsoleWriter;

public final class ClearPairView {
	private static final String NOTICE = "초기화 되었습니다.";

	public static void response() {
		ConsoleWriter.printlnMessage(NOTICE);
	}
}
