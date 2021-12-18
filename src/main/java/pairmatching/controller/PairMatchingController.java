package pairmatching.controller;

import pairmatching.model.PairMatching;
import pairmatching.view.OptionView;

public class PairMatchingController {

	private PairMatching pairMatching;

	public PairMatchingController(PairMatching pairMatching) {
		this.pairMatching = pairMatching;
	}

	public void operate() {
		OptionView optionView = new OptionView();
		pairMatching.executeOption(optionView.getInput());
	}
}
