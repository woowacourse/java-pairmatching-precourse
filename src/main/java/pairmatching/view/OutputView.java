package pairmatching.view;

import java.util.List;
import java.util.stream.Collectors;

import org.omg.CORBA.INITIALIZE;

import pairmatching.domain.Crew;

public class OutputView {

	private static final String SELECT_MENU = "기능을 선택하세요.";
	private static final String SELECT_MENU_ONE = "1. 페어 매칭";
	private static final String SELECT_MENU_TWO = "2. 페어 조회";
	private static final String SELECT_MENU_THREE = "3. 페어 초기화";
	private static final String SELECT_MENU_END = "Q. 종료";
	private static final String SEPARATOR = "#############################################";
	private static final String COURSE = "과정: 백엔드 | 프론트엔드";
	private static final String MISSION = "미션:\n"
		+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
		+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
		+ "  - 레벨3: \n"
		+ "  - 레벨4: 성능개선 | 배포\n"
		+ "  - 레벨5: ";
	private static final String OUTPUT_EXAMPLE = "과정, 레벨, 미션을 선택하세요.\n"
		+ "ex) 백엔드, 레벨1, 자동차경주";
	private static final String REMATCHING_OR_PRINT = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
	private static final String FIND_PAIR_RESULT = "페어 매칭 결과입니다.";
	private static final String DELIMITER = " : ";
	private static final String INITIALIZE = "초기화 되었습니다.";

	public static void printInputMainMenu() {
		System.out.println(SELECT_MENU);
		System.out.println(SELECT_MENU_ONE);
		System.out.println(SELECT_MENU_TWO);
		System.out.println(SELECT_MENU_THREE);
		System.out.println(SELECT_MENU_END);
	}

	public static void printException(Exception exception) {
		System.out.println("[ERROR] " + exception.getMessage());
	}

	public static void printInputInformation() {
		printNewLine();
		System.out.println(SEPARATOR);
		System.out.println(COURSE);
		System.out.println(MISSION);
		System.out.println(SEPARATOR);
		System.out.println(OUTPUT_EXAMPLE);
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printReMatchingOrPrint() {
		printNewLine();
		System.out.println(REMATCHING_OR_PRINT);
	}

	public static void printResultFindPair() {
		printNewLine();
		System.out.println(FIND_PAIR_RESULT);
	}

	public static void printPair(List<Crew> pair) {
		System.out.println(pair.stream()
			.map(Crew::getName)
			.collect(Collectors.joining(DELIMITER)));
	}

	public static void printFindPairByInputMenu() {
		printInputInformation();
	}

	public static void PrintInitialize() {
		printNewLine();
		System.out.println(INITIALIZE);
	}
}
