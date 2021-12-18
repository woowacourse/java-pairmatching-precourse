package pairmatching.view;

public class OutputView {
	private static final String ERROR_PREFIX = "[ERROR] %s";
	private static final String IO_ERROR = "파일을 읽어오는데 문제가 발생했습니다.";

	private static final String MAIN_MENU = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";

	public static void printIoError() {
		System.out.println(String.format(ERROR_PREFIX, IO_ERROR));
	}

	public static void printMainMenu() {
		System.out.println(MAIN_MENU);
	}
}
