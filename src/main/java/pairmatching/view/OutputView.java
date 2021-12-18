package pairmatching.view;

public class OutputView {

	private static final String ERROR_FORM = "[ERROR] ";

	public static void printError(IllegalArgumentException exception) {
		System.out.println(ERROR_FORM + exception.getMessage());
	}

}
