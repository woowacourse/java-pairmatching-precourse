package pairmatching.service;

import pairmatching.model.PairMatching;
import pairmatching.view.OptionView;

public class PairMatchingSerivce {

	public PairMatching executeUntilUserFinish(PairMatching pairMatching) {

		while (!pairMatching.isFinish()) {
			pairMatching = execute(pairMatching);
		}

		return pairMatching;
	}

	private PairMatching execute(PairMatching pairMatching) {
		OptionView optionView = new OptionView();
		pairMatching.executeOption(optionView.getInput());
		return pairMatching;
	}
}
