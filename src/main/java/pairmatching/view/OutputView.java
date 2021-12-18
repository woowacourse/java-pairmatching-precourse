package pairmatching.view;

import java.util.List;

import pairmatching.domain.Pair;

public class OutputView {

	private static final String ERROR_FORM = "[ERROR] ";
	private static final String INIT_MESSAGE = "초기화 되었습니다.\n";
	private static final String MATCHING_RESULT_MESSAGE = "페어 매칭 결과입니다.\n";
	private static final String MENU_LIST = "#############################################\n"
		+ "과정: 백엔드 | 프론트엔드\n"
		+ "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: \n"
		+ "############################################";

	public static void printError(IllegalArgumentException exception) {
		System.out.println(ERROR_FORM + exception.getMessage() + "\n");
	}

	public static void printInitMessage() {
		System.out.println(INIT_MESSAGE);
	}

	public static void printMatching(List<Pair> pairs) {
		StringBuilder builder = new StringBuilder();
		builder.append(MATCHING_RESULT_MESSAGE);
		for (Pair pair : pairs) {
			builder.append(pair.toString())
				.append("\n");
		}

		System.out.println(builder.toString());
	}

	public static void printMenu() {
		System.out.println(MENU_LIST);
	}

}
