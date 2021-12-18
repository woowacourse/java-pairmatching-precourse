package pairmatching.view;

public class InputView {
	public static final String SELECT_FUNCTION_MESSAGE = "기능을 선택하세요.";
	public static final String PAIR_MATCHING_MESSAGE = "1. 페어 매칭";
	public static final String PAIR_CHECK_MESSAGE = "2. 페어 조회";
	public static final String PAIR_INITIALIZATION_MESSAGE = "3. 페어 초기화";
	public static final String PAIR_EXIT_MESSAGE = "Q. 종료";

	public static void askSelectFunction() {
		System.out.println(SELECT_FUNCTION_MESSAGE);
		System.out.println(PAIR_MATCHING_MESSAGE);
		System.out.println(PAIR_CHECK_MESSAGE);
		System.out.println(PAIR_INITIALIZATION_MESSAGE);
		System.out.println(PAIR_EXIT_MESSAGE);
	}
}
