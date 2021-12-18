package pairmatching.controller;

import pairmatching.model.PairMatching;
import pairmatching.service.PairMatchingSerivce;

public class PairMatchingController {

	private PairMatching pairMatching;
	private PairMatchingSerivce pairMatchingSerivce;

	public PairMatchingController(PairMatching pairMatching) {
		this.pairMatching = pairMatching;
		pairMatchingSerivce = new PairMatchingSerivce();
	}

	public void operate() {
		pairMatching = pairMatchingSerivce.executeUntilUserFinish(pairMatching);
	}
}
