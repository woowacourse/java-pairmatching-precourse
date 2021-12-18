package pairmatching.view;

public class OutputView {

	private static final String ERROR_FORM = "[ERROR] ";

	public static void printError(IllegalArgumentException exception) {
		System.out.println(ERROR_FORM + exception.getMessage() + "\n");
	}

	public static void printInitMessage() {
		System.out.println("\n초기화 되었습니다.\n");
	}
}
