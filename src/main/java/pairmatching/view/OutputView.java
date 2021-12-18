package pairmatching.view;

import pairmatching.domain.PairMatching;

public class OutputView {
	private PairMatching pairMatching;

	public OutputView(PairMatching pairMatching) {
		this.pairMatching = pairMatching;
	}

	public void printMainMenu() {
		System.out.println("기능을 선택하세요.");
		pairMatching.getMainMenu().printMainMenus();
	}

	public void printPairMatchingInfo() {
		System.out.println("#############################################");
		System.out.print("과정: ");
		System.out.println(String.join(" | ", pairMatching.getGetRoll()));
		System.out.println("미션: ");
	}
}
