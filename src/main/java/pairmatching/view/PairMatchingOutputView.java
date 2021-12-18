package pairmatching.view;

public class PairMatchingOutputView {
	private static final String FUNCTION_INPUT = "기능을 선택하세요.";
	private static final String PAIR_MATCHING_FUNCTION = "1. 페어 매칭";
	private static final String PAIR_FINDING_FUNCTION = "2. 페어 조회";
	private static final String PAIR_INITIALIZING_FUNCTION = "3. 페어 초기화";
	private static final String QUIT_FUNCTION = "Q. 종료";
	private static final String LINE_WRAPPING = "\n";

	private PairMatchingOutputView() {
	}

	public static void printFunctionInputMessage() {
		StringBuilder functionInputMessage = new StringBuilder();
		functionInputMessage.append(FUNCTION_INPUT)
			.append(LINE_WRAPPING)
			.append(PAIR_MATCHING_FUNCTION)
			.append(LINE_WRAPPING)
			.append(PAIR_FINDING_FUNCTION)
			.append(LINE_WRAPPING)
			.append(PAIR_INITIALIZING_FUNCTION)
			.append(LINE_WRAPPING)
			.append(QUIT_FUNCTION);
		System.out.println(functionInputMessage.toString());
	}
}
