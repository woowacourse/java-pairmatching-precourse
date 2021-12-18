package pairmatching.view;

public class ErrorView {
	private static final String ERROR_PREFIX = "[ERROR] ";

	public static void printErrorMesasge(String errorMessage) {
		System.out.println(ERROR_PREFIX + errorMessage);
		System.out.println();
	}
}
