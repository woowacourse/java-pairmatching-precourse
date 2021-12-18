package pairmatching.service;

import pairmatching.constant.Message;
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
		try {
			OptionView optionView = new OptionView();
			pairMatching.executeOption(optionView.getInput());
		} catch (IllegalArgumentException e) {
			System.out.println(Message.ERROR + e.getMessage() + "\n");
		}
		return pairMatching;
	}
}
