package pairmatching.view;

import java.util.List;

public class OutputView {
	private static final int LAST_THREE = 3;
	private static final int LAST_TWO = 2;
	private static final int LAST_ONE = 1;
	private static final int NEXT_ONE = 1;
	private static final String PAIR_RESULT = "페어 매칭 결과입니다.";
	private static final String TWO_PAIR = "%s : %s%n";
	private static final String THREE_PAIR = "%s : %s : %s%n";

	public static void showError(String message) {
		System.out.println(message);
	}

	public static void showCrewList(List<String> crewList) {
		System.out.println();
		System.out.println(PAIR_RESULT);
		if (isOdd(crewList.size())) {
			printOdd(crewList);
			System.out.println();
			return;
		}
		printEven(crewList);
		System.out.println();
	}

	private static void printOdd(List<String> crewList) {
		for (int index = 0; index < crewList.size() - LAST_THREE; index++) {
			if (isOdd(index)) {
				continue;
			}
			System.out.printf(TWO_PAIR, crewList.get(index), crewList.get(index + NEXT_ONE));
		}
		System.out.printf(THREE_PAIR, crewList.get((crewList.size() - LAST_THREE)),
			crewList.get((crewList.size() - LAST_TWO)),
			crewList.get((crewList.size() - LAST_ONE)));
	}

	private static boolean isOdd(int number) {
		return number % 2 == 1;
	}

	private static void printEven(List<String> crewList) {
		for (int index = 0; index < crewList.size(); index++) {
			if (isOdd(index)) {
				continue;
			}
			System.out.printf(TWO_PAIR, crewList.get(index), crewList.get(index + NEXT_ONE));
		}
	}

	public static void printMission() {
		System.out.println();
		System.out.println("#############################################");
		System.out.println("과정: 백엔드 | 프론트엔드");
		System.out.println("미션:");
		System.out.println("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임");
		System.out.println("  - 레벨2: 장바구니 | 결제 | 지하철노선도");
		System.out.println("  - 레벨3: ");
		System.out.println("  - 레벨4: 성능개선 | 배포");
		System.out.println("  - 레벨5: ");
		System.out.println("#############################################");
	}
}
