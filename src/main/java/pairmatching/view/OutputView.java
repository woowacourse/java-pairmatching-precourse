package pairmatching.view;

import java.util.List;

public class OutputView {
	public static void showError(String message) {
		System.out.println(message);
	}

	public static void showCrewList(List<String> crewList) {
		System.out.println();
		System.out.println("페어 매칭 결과입니다.");
		if (crewList.size() % 2 == 1) {
			printOdd(crewList);
			System.out.println();
			return;
		}
		printEven(crewList);
		System.out.println();
	}

	private static void printOdd(List<String> crewList) {
		for (int i = 0; i < crewList.size() - 3; i++) {
			if (i % 2 == 1) {
				continue;
			}
			System.out.printf("%s : %s%n", crewList.get(i), crewList.get(i+1));
		}
		System.out.printf("%s : %s : %s%n", crewList.get((crewList.size()-3)), crewList.get((crewList.size()-2)), crewList.get((crewList.size()-1)));
	}

	private static void printEven(List<String> crewList) {
		for (int i = 0; i < crewList.size(); i++) {
			if (i % 2 == 1) {
				continue;
			}
			System.out.printf("%s : %s%n", crewList.get(i), crewList.get(i+1));
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
