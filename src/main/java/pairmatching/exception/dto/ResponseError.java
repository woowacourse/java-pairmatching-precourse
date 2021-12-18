package pairmatching.exception.dto;

public class ResponseError {
	private static final String ERROR = "[ERROR] ";

	public static void of(String errorMessage) {
		System.out.println(ERROR + errorMessage);
	}
}
