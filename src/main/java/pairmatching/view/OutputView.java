package pairmatching.view;

public class OutputView {
	private static final String NEW_LINE = "\n";
	private static final String MAIN_OPTION_MATCHING = "1. 페어 매칭";
	private static final String MAIN_OPTION_GET_INFO = "2. 페어 조회";
	private static final String MAIN_OPTION_INIT = "3. 페어 초기화";
	private static final String MAIN_OPTION_QUIT = "Q. 종료";

	public static void displayMainView() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(MAIN_OPTION_MATCHING).append(NEW_LINE)
			.append(MAIN_OPTION_GET_INFO).append(NEW_LINE)
			.append(MAIN_OPTION_INIT).append(NEW_LINE)
			.append(MAIN_OPTION_QUIT).append(NEW_LINE);
		System.out.println(stringBuilder);
	}
}
