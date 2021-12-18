package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.model.PairMatching;

public class Application {
	public static void main(String[] args) {

		PairMatching pairMatching = new PairMatching();
		PairMatchingController pairMatchingController = new PairMatchingController(pairMatching);
		pairMatchingController.operate();
	}
}
