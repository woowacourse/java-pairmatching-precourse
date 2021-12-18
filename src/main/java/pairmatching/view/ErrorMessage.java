package pairmatching.view;

public class ErrorMessage {
	private static final String ERROR_MESSAGE_PREFIX = "[ERROR] %s\n";

	public static void print(String message) {
		System.out.printf(ERROR_MESSAGE_PREFIX, message);
	}
}
