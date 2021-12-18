package pairmatching.view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import pairmatching.domain.PairMatching;

public class OutputView {
	private PairMatching pairMatching;

	public OutputView(PairMatching pairMatching) {
		this.pairMatching = pairMatching;
	}

	public void printMatchingResult(String roll, String level) {
		System.out.println();
		System.out.println("페어 매칭 결과입니다.");
		pairMatching.getCrew().printCrews(roll, level);

	}

	public void printMainMenu() {
		System.out.println();
		System.out.println("기능을 선택하세요.");
		pairMatching.getMainMenu().printMainMenus();
	}

	public void printPairMatchingInfo() {
		System.out.println();
		System.out.println("#############################################");
		System.out.print("과정: ");
		System.out.println(String.join(" | ", pairMatching.getGetRoll()));
		System.out.println("미션: ");
		Map<String, List<String>> levelMap = pairMatching.getLevel().getLevelMap();
		for (String levelName : levelMap.keySet()) {
			System.out.println("  - " + levelName + ": " + String.join(" | ", levelMap.get(levelName)));
		}
		System.out.println("#############################################");
	}
}
