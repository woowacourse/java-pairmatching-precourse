package pairmatching.view;

public class InputView {
	public static final String REQUEST_FOR_FUNCTION_OPTION_INPUT = "기능을 선택하세요.";

	public static void printFunctionOptions() {
		System.out.println(REQUEST_FOR_FUNCTION_OPTION_INPUT);
		System.out.println("1. 페어 매칭");
		System.out.println("2. 페어 조회");
		System.out.println("3. 페어 초기화");
		System.out.println("Q. 종료");
	}
}
