package pairmatching.view;

public class ErrorView {
	private static final String PREFIX = "[Error] ";

	public static void print(String error) {
		System.out.println(PREFIX + error);
	}
}
