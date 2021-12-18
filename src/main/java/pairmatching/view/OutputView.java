package pairmatching.view;

public class OutputView {

	public static final String ERROR_PREFIX = "[ERROR] ";

	public static void printInputFunctionMenuInstruction() {
		System.out.println();
		System.out.println("기능을 선택하세요.");
		System.out.println("1. 페어 매칭");
		System.out.println("2. 페어 조회");
		System.out.println("3. 페어 초기화");
		System.out.println("Q. 종료");
	}

	public static void printError(String message) {
		System.out.println(ERROR_PREFIX + message);
	}
}


