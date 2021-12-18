package pairmatching;

import pairmatching.controller.ChoiceFunctionController;
import pairmatching.controller.PairMatchingController;

public class Application {
	private static final String PAIR_MATCHING = "1";
	private static final String END = "Q";

	private static final ChoiceFunctionController choiceFunctionController = new ChoiceFunctionController();
	private static final PairMatchingController pairMatchingController = new PairMatchingController();

	public static void main(String[] args) {
		// TODO 구현 진행
		while (true) {
			String function = choiceFunctionController.choiceFunction();
			if (function.equals(PAIR_MATCHING)) {
				pairMatchingController.pairMatching();
			}
			if (function.equals(END)) {
				break;
			}
		}
	}
}
