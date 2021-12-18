package pairmatching.util;

public final class ExceptionHandler {
	public static void handleInputError(boolean isValid, String errorMessage) {
		try {
			if (!isValid) {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException exception) {
			System.out.println(errorMessage);
		}
	}
}