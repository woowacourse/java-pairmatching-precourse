package pairmatching.view;

import java.util.List;

public class OutputView {
	public static void showError(String message) {
		System.out.println(message);
	}

	public static void showCrewList(List<String> crewList) {
		System.out.println();
		System.out.println(crewList.toString());
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
}
