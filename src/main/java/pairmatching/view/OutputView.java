package pairmatching.view;

public class OutputView {
	public static final String ERROR_FORMAT = "[ERROR] %s%n";

	public static void printError(Exception exception) {
		System.out.printf(ERROR_FORMAT, exception.getMessage());
	}
}
