package pairmatching;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.StringTokenizer;

public class Match {
	private static final String MENU = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";
	private static final String ERRMESSAGE= "[ERROR] 잘못 입력하셨습니다.";
	private static final String MATCHPAIRHEAD = "#############################################\n"
										+ "과정: 백엔드 | 프론트엔드\n"
										+ "미션:\n"
										+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
										+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
										+ "  - 레벨3: \n"
										+ "  - 레벨4: 성능개선 | 배포\n"
										+ "  - 레벨5: \n"
										+ "############################################\n";
	private static final String CLECTMATCHPAIR = "과정, 레벨, 미션을 선택하세요.\n"
												+ "ex) 백엔드, 레벨1, 자동차경주";

	public static void run() {
		String menu;

		while(true) {
			boolean exit;
			printMenu();
			try {
				menu = getMenuInput();
				exit = runMenu(menu);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				continue;
			}
			if (exit) {
				break;
			}
		}
	}

	private static void printMenu() {
		System.out.println(MENU);
	}

	private static String getMenuInput() {
		return readLine();
	}

	private static boolean runMenu(String menu) {
		if (menu.equals("1")) {
			matchPair();
			return true;
		}
		if (menu.equals("2")) {
			inqueryPair();
			return true;
		}
		if (menu.equals("3")) {
			resetPair();
			return true;
		}
		if (menu.equals("Q")) {
			return false;
		}
		throw new IllegalArgumentException(ERRMESSAGE);
	}
	private static void matchPair() {
		printMatchPairHead();
		while(true) {
			try {
				printSelectMatchPair();
				CourseLevelMission courseLevelMission = getCourseLevelMission();
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private static void printMatchPairHead() {
		System.out.println(MATCHPAIRHEAD);
	}
	private static void printSelectMatchPair() {
		System.out.println(CLECTMATCHPAIR);
	}
	private static CourseLevelMission getCourseLevelMission() {
		String input = readLine();

		validateCourseLevelMission(input);

		StringTokenizer st = new StringTokenizer(input);
		Course course = Course.valueOf(st.nextToken());
		Level level = Level.valueOf(st.nextToken());
		String mission = st.nextToken();

		return new CourseLevelMission(course, level, mission);
	}
	private static void validateCourseLevelMission(String input) {
		String[] inputArray = input.split(", ");
		if (inputArray.length != 3) {
			throw new IllegalArgumentException(ERRMESSAGE);
		}
		if (!Course.toArrayname().contains(inputArray[0])) {
			throw new IllegalArgumentException(ERRMESSAGE);
		}
		if (!Level.toArrayname().contains(inputArray[1])) {
			throw new IllegalArgumentException(ERRMESSAGE);
		}
	}
	private static void inqueryPair() {

	}
	private static void resetPair() {

	}
}
