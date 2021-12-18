package pairmatching.view;

public class OutputView {
	private static final String SELECT_FUNTION_MESSAGE = "기능을 선택하세요";
	private static final String PAIR_MATCHING_MESSAGE = "1. 페어 매칭";
	private static final String PAIR_FIND_MESSAGE = "2. 페어 조회";
	private static final String PAIR_INITIALIZATION_MESSAGe = "3. 페어 초기화";
	private static final String EXIT_MEESAGE = "Q. 종료";

	private OutputView() {
	}

	public static void askSelectFunction() {
		System.out.println(SELECT_FUNTION_MESSAGE);
		System.out.println(PAIR_MATCHING_MESSAGE);
		System.out.println(PAIR_FIND_MESSAGE);
		System.out.println(PAIR_INITIALIZATION_MESSAGe);
		System.out.println(EXIT_MEESAGE);
	}
}
