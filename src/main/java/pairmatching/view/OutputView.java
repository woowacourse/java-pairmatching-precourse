package pairmatching.view;

public class OutputView {
	public static void printMain() {
		printHeader("기능을 선택하세요.");
		printOptionMenu("1", "페어 매칭");
		printOptionMenu("2", "페어 조회");
		printOptionMenu("3", "페어 초기화");
		printOptionMenu("Q", "종료");
	}

	public static void printErrorMessage(String message) {
		printError(message);
	}

	private static void printHeader(String header) {
		System.out.println(header);
	}

	private static void printOptionMenu(String option, String name) {
		System.out.println(option + ". " + name);
	}

	private static void printError(String message) {
		System.out.println("[ERROR] " + message);
	}

	private static void printBlankLine() {
		System.out.println();
	}
}
